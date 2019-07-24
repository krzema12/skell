#!/bin/bash
set -eu
set -o pipefail

VARIABLE_1=$1
VARIABLE_2=$2
VARIABLE_3=$3
VARIABLE_4=$4
AWS_REGION=$5

shift 5
VARIABLE_5=("$@")

if [ ! -d ${VARIABLE_2} ]; then
    echo "ERROR: ${VARIABLE_2} does not exist"
    exit 1
fi
export PATH=${VARIABLE_2}/bin:/usr/local/bin:/usr/bin:/bin:${PATH}
export LD_LIBRARY_PATH=${VARIABLE_2}/lib:${LD_LIBRARY_PATH:-}

VARIABLE_6=/path1
if [ ! -d ${VARIABLE_6} ]; then
    echo "ERROR: Directory not found: ${VARIABLE_6}"
    exit 1
fi

VARIABLE_7=${VARIABLE_6}/path2
if [ ! -d ${VARIABLE_7} ]; then
    echo "Message 1 ${VARIABLE_7}"
    custom-script-1 ${VARIABLE_7} --flag1
else
    echo "Message 2: ${VARIABLE_7}"
fi

VARIABLE_8=${VARIABLE_6}/path3
mkdir -p ${VARIABLE_8}
aws s3 sync ${VARIABLE_1}/path4/ ${VARIABLE_8} --region ${AWS_REGION}

export PYTHONIOENCODING=utf8

VARIABLE_9=${VARIABLE_6}/path5
mkdir -p ${VARIABLE_9}

export VARIABLE_10=true
custom-command-from-path -p ${VARIABLE_7} param1 param2 param3 param4=${VARIABLE_8} param5=${VARIABLE_9}
trap "custom-script-2.sh --parameter1 ${VARIABLE_7} --parameter2 ${VARIABLE_9} --parameter3 ${VARIABLE_1}" EXIT

set +e
VARIABLE_11=0
for i in {1..2}; do
    custom-command-from-path --parameter1 ${VARIABLE_7} parameter2 ${VARIABLE_3} --flag1 > /dev/null
    VARIABLE_11=$?
    if [ ${VARIABLE_11} -eq 0 ]; then
        break
    fi
    sleep 30
done
set -e

if [ ${VARIABLE_11} -ne 0 ]; then
    exit ${VARIABLE_11}
fi

VARIABLE_12=$VARIABLE_6/path6
echo "Message 3 ${VARIABLE_12}"
mkdir -p ${VARIABLE_12}
for VARIABLE_13 in "${VARIABLE_5[@]}"; do
    VARIABLE_14=$(echo "${VARIABLE_13}" | cut -f1 -d' ')
    VARIABLE_15=$(echo "${VARIABLE_13}" | cut -f2 -d' ')
    custom-command-from-path --parameter1 ${VARIABLE_7} parameter2 -p ${VARIABLE_12}/${VARIABLE_15} ${VARIABLE_3}/${VARIABLE_14}
done

echo "Message 4 ${VARIABLE_12}"
ls ${VARIABLE_12}

VARIABLE_16=${VARIABLE_12}.tar.gz
pushd ${VARIABLE_12}
tar -czf $VARIABLE_16 ./*
popd
aws s3 cp $VARIABLE_16 ${VARIABLE_1}/path7/${VARIABLE_4} --region ${AWS_REGION}
