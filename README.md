mvn site
========

gitlab ci example maven project with handover between mvn install and mvn site stages in a multi-module build

To reproduce my issue:

Working:

```
mvn install
mvn site
```


Failing:
 
```
mvn versions:set -DnextSnapshot=true
mvn site
```

Error:

```
[ERROR] Failed to execute goal on project ci-main: Could not resolve dependencies for project de.fhg.igd.iva.examples:ci-main:jar:1.0.3-SNAPSHOT: Could not find artifact de.fhg.igd.iva.examples:ci-lib:jar:1.0.3-SNAPSHOT -> [Help 1]
```

Whats wrong with my setup? Is `mvn site` only possible with a `mvn install`?



With `mvn -X site`, it is becoming clearer that site does not look into the current projects `target/` directories... But how can I change this?

```
[DEBUG] =======================================================================
[DEBUG] Could not find metadata de.fhg.igd.iva.examples:ci-lib:1.0.3-SNAPSHOT/maven-metadata.xml in local (C:\Users\foobar\.m2\repository)
[DEBUG] Dependency collection stats: {ConflictMarker.analyzeTime=96200, ConflictMarker.markTime=110900, ConflictMarker.nodeCount=2, ConflictIdSorter.graphTime=33300, ConflictIdSorter.topsortTime=23400, ConflictIdSorter.conflictIdCount=1, ConflictIdSorter.conflictIdCycleCount=0, ConflictResolver.totalTime=707000, ConflictResolver.conflictItemCount=1, DefaultDependencyCollector.collectTime=62164800, DefaultDependencyCollector.transformTime=1001100}
[DEBUG] de.fhg.igd.iva.examples:ci-main:jar:1.0.3-SNAPSHOT
[DEBUG]    de.fhg.igd.iva.examples:ci-lib:jar:1.0.3-SNAPSHOT:compile
[DEBUG] Could not find metadata de.fhg.igd.iva.examples:ci-lib:1.0.3-SNAPSHOT/maven-metadata.xml in local (C:\Users\foobar\.m2\repository)
```