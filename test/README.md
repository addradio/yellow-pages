# Test code for AddRadio yellow pages XML schema

## Manual schema validation

If you want to validate your xml files against the schema, run

    xmllint --noout --schema addradio_yellow-pages_v1.xsd path/to/your/xml/file

in the root directory of this project (replace placeholder above with your xml path).

## Schema serialization integration tests

Go into the java subdirectory and run

    mvn clean test

to start the serialization integration test.
This maven project contains example code for schema based jaxb code generation and xml serialization.

Requirements:
- `maven`
- `java`

## Guardfile

If you want to automatically watch and validate your xml files, go into the root directory (one above this one) and run

    guard -G test/Guardfile

Requirements:
- `xmllint` commandline utility
- `ruby` runtime environment
- `guard` and `guard-shell` rubygems

