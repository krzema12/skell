# Skell
Safety of Kotlin, conciseness of shell

It's a library that aims at simplifying file-based operations in Kotlin.
Looking at shell commands, such operations are bread and butter there:

```bash
mkdir testDir
cd testDir
touch newFile
ls

echo "Hello!" > newFile
cat newFile
```

Skell wants to make it equally simple in Kotlin, while giving you all the benefits of a modern and safe langauge:

```kotlin
mkdir("testDir")
cd("testDir") {
    touch("newFile")
    ls()
    
    "Hello!" writeTo file("newFile")
    println(readFrom(file("newFile")))
}
```

Its API is not the best fit for a command-line, but rather for pieces of code that has to be maintained for a longer period of time.
That's why certain things are made more explicit.

This library is still in a "proof of concept" stage.
