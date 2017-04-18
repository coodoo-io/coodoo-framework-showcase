# coodoo-framework-showcase

> Showcase implementation of coodoo framework libraries

## Table of Contents

- [Background](#background)
- [Install](#install)
- [Usage](#usage)
  - [Demo application](#demo-application)
  - [Listing](#listing)
  - [App config](#app-config)
  - [Audit](#audit)
  - [File export](#file-export)
- [Maintainers](#maintainers)
- [Contribute](#contribute)
- [License](#license)

## Background

The best way to show how things work is to give some examples. So this project is stuffed with examples on how to use the features of the coodoo framework libraries.

This project contains a little demo application that combines all available coodoo frameworks* and a blank showcase of each coodoo library for it alone. 

So far there are:
- [coodoo-listing](https://github.com/coodoo-io/coodoo-listing) *JavaEE JPA/JAX-RS Listing Framework*
- [coodoo-app-config](https://github.com/coodoo-io/coodoo-app-config) *Simple persistent application configuration service* `*`
- [coodoo-audit](https://github.com/coodoo-io/coodoo-audit) *Audit framework to store data changes by observing JPA events* `*`
- [coodoo-file-export](https://github.com/coodoo-io/coodoo-file-export) *Convenience util to provide POJO list exports as downloadable files in a JavaEE/Rest environment* `*`


`*`: *Not implemented yet*


## Install

To run this project on your own you'll need a [WildFly 10.x](http://wildfly.org/downloads/) application server and a H2 datasource defined in the `standalone.xml` like this:

```xml
<datasources>
    <datasource jndi-name="java:jboss/datasources/ShowcaseDS" pool-name="ShowcaseDS">
        <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1</connection-url>
        <driver>h2</driver>
        <pool>
            <min-pool-size>10</min-pool-size>
            <max-pool-size>20</max-pool-size>
            <prefill>true</prefill>
        </pool>
        <security>
            <user-name>sa</user-name>
            <password>sa</password>
        </security>
    </datasource>
    <drivers>
        <driver name="h2" module="com.h2database.h2">
            <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
        </driver>
    </drivers>
</datasources>
```

## Usage

### Demo application

*Not implemented yet*

### Listing

The
[Code](https://github.com/coodoo-io/coodoo-framework-showcase/tree/master/src/main/java/io/coodoo/framework/showcase/listing)
for the example implementation of coodoo-listing provides a 
[Rest resource](./src/main/java/io/coodoo/framework/showcase/listing/boundary/ListingResource.java)
and a 
[stateless EJB](./src/main/java/io/coodoo/framework/showcase/listing/boundary/ListingService.java)
that will give you listing access to an 
[entity](./src/main/java/io/coodoo/framework/showcase/listing/entity/Car.java)
.

#### Examples

Here are
[examples](https://github.com/coodoo-io/coodoo-framework-showcase/tree/master/src/main/java/io/coodoo/framework/showcase/listing/boundary/examples)
that focus an following issues:

- [Filter (search on whole table)](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/ListingFilterService.java)
- [Filter attributes](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/ListingFilterAttributesService.java)
  - [Text](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/types/ListingFilterTextService.java)
  - [Number](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/types/ListingFilterNumberService.java)
  - [Date](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/types/ListingFilterDateService.java)
  - [Boolean](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/types/ListingFilterBooleanService.java)
- [Pagination](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/ListingPaginationService.java)
- [Sort](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/ListingSortService.java)
- [Predicates](./src/main/java/io/coodoo/framework/showcase/listing/boundary/examples/ListingPredicateService.java)


### App config

*Not implemented yet*

### Audit

*Not implemented yet*

### File export

*Not implemented yet*


## Maintainers

[Markus Kühle](https://github.com/mkuehle)

[Arend Kühle](https://github.com/laugen)

## Contribute

Pull requests and [issues](https://github.com/coodoo-io/coodoo-framework-showcase/issues) are welcome.

## License

[MIT © coodoo GmbH](./LICENSE)
