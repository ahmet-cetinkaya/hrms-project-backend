# Api Documentation
Api Documentation

## Version: 1.0

### Terms of service
urn:tos

**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### /api/companystaffverifications/verify

#### GET
##### Summary

verify

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | id | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/emailactivations/verify

#### GET
##### Summary

verify

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| authToken | query |  | No | string |
| email | query |  | No | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/employers/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«Employer»»](#dataresult«list«employer»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/employers/register

#### POST
##### Summary

register

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| employerForRegisterDto | body | employerForRegisterDto | Yes | [EmployerForRegisterDto](#employerforregisterdto) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobpositions/add

#### POST
##### Summary

getAll

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobPosition | body | jobPosition | Yes | [JobPosition](#jobposition) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobpositions/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobPosition»»](#dataresult«list«jobposition»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeeker»»](#dataresult«list«jobseeker»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/register

#### POST
##### Summary

register

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerForRegisterDto | body | jobSeekerForRegisterDto | Yes | [JobSeekerForRegisterDto](#jobseekerforregisterdto) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### Models

#### DataResult«List«Employer»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [Employer](#employer) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobPosition»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobPosition](#jobposition) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeeker»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeeker](#jobseeker) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### Employer

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| companyName | string |  | No |
| corporateEmail | string |  | No |
| phone | string |  | No |
| userId | integer |  | No |
| website | string |  | No |

#### EmployerForRegisterDto

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| companyName | string |  | No |
| confirmPassword | string |  | No |
| corporateEmail | string |  | No |
| email | string |  | No |
| password | string |  | No |
| phone | string |  | No |
| website | string |  | No |

#### JobPosition

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | integer |  | No |
| title | string |  | No |

#### JobSeeker

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| birthDate | dateTime |  | No |
| firstName | string |  | No |
| identityNumber | string |  | No |
| lastName | string |  | No |
| userId | integer |  | No |

#### JobSeekerForRegisterDto

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| birthDate | dateTime |  | No |
| confirmPassword | string |  | No |
| email | string |  | No |
| firstName | string |  | No |
| identityNumber | string |  | No |
| lastName | string |  | No |
| password | string |  | No |

#### Result

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| message | string |  | No |
| success | boolean |  | No |
