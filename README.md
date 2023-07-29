# demo-oxford-dictionary-test
___
Using serenity to perform automation test on oxford learners' dictionary website

#### Run the test script
- at your desktop:  
```java
mvn clean verify -Dit.test=WhenSearchingForATermStory
```
- at remote (browserstack):
```java
mvn -f pom_remote.xml verify -Dtags="browserstack:remote" -P bisllly-remote
```


