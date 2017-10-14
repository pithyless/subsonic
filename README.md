# Setup

## Must have
* JDK (Java Development Kit), minimum version 8
* [boot-clj](https://github.com/boot-clj/boot/blob/master/README.md#install)

## Nice to have
* git
* Chrome browser

## How to test?

```
java -version

git --version

boot -h
```

# Play

```
 export BOOT_JVM_OPTIONS="-client -XX:+TieredCompilation -XX:TieredStopAtLevel=1 -Xms4g -Xmx4g -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -Xverify:none"

boot run
```

Open [localhost:4000](http://localhost:4000)
