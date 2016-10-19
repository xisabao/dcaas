# User Database Schema

## users
|id|user-id|password-hash|salt-alpha|salt-beta|
|-|-|-|-|-|
|1|jake|hash of password+alpha|password-associated hash|data-associated-hash|
|2|nicholas|hash of password+alpha|password-associated hash|link-associated-hash|
|3|adminuser|hash of password|password-associated hash|link-associated-hash|

## example-data-link
|id|entry-id|link-hash|
|-|-|-|-|
|1|16556|hash of password+beta|
|2|19223|hash of password+beta|
|3|24004|hash of password+beta|
