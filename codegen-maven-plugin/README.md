codegen-maven-plugin
============================

A Maven plugin to support the [codegen](https://github.com/ConsumerDataStandardsAustralia/java-artefacts/codegen) project

Usage
============================

Add to your `build->plugins` section (default phase is `generate-sources` phase)
```xml
<plugin>
    <groupId>au.org.consumerdatastandards</groupId>
    <artifactId>cds-codegen-maven-plugin</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <language>java</language>
                <output>${project.build.directory}/generated-sources/cds-client</output>
                <configOptions>
                   <sourceFolder>src/gen/java/main</sourceFolder>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Followed by:

```
mvn clean compile
```

### General Configuration parameters

- `language` - target generation language
- `output` - target output path (default is `${project.build.directory}/generated-sources/output`)

