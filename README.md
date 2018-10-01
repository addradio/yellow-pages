# yellow-pages

This Project contains the XML schema definition, XML examples and tools on how to deal with data transfered by AddRadio Yellow Page Services.

## Schema

We are working with a "schema first" approach, e.g. the XML schema is the source of all truth for this project.
Any document supplied will validate correctly against the schema.

Please study the schema carefully, all possible values for attributes/elements are defined in there.

## Example

Attached is an example xml file describing a typical document.

Please keep in mind that the example file is kept short for readability, real instances of this document will represent the complete broadcaster tree (all stations, channels, streams).

## Workflow

The document represents the complete broadcaster structure.

We will probably need a CRUD workflow for creating/updating/deleting specific fragments of the data (channel properties, stream properties) without submitting the complete document.

## Validations, Java example code, tests

Refer to the documentation in `test/README.md` for further information.

## Contributing

Feel free to post issues and/or pull requests.

## Copyright

Copyright (c) 2018 AddRadio - a division of nacamar GmbH, Germany. See [GNU Affero General Public License v3.0](LICENSE) for details.
