# Api Documentation
Api Documentation

## Version: 1.0

### Terms of service
urn:tos

**License:** [Apache 2.0](http://www.apache.org/licenses/LICENSE-2.0)

### /api/cities/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«City»»](#dataresult«list«city»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/cities/getbyid

#### GET
##### Summary

getById

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | id | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«City»](#dataresult«city») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/cities/getbyname

#### GET
##### Summary

getByName

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| name | query | name | No | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«City»](#dataresult«city») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/cities/getbynamecontains

#### GET
##### Summary

getByNameContains

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| name | query | name | No | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«City»»](#dataresult«list«city»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/companystaffverifications/verify

#### GET
##### Summary

verify

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| userId | query | userId | Yes | integer |

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
| activationCode | query |  | No | string |
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

### /api/jobadverts/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobAdvert | body | jobAdvert | Yes | [JobAdvert](#jobadvert) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobadverts/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobAdvert»»](#dataresult«list«jobadvert»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobadverts/getall/forlist/byisactive

#### GET
##### Summary

getAllByIsActiveForList

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| isActive | query | isActive | Yes | boolean |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobAdvertForListDto»»](#dataresult«list«jobadvertforlistdto»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobadverts/getall/forlist/byisactiveandemployercompanyname

#### GET
##### Summary

getAllByIsActiveAndEmployer_CompanyNameForList

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| companyName | query | companyName | Yes | string |
| isActive | query | isActive | Yes | boolean |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobAdvertForListDto»»](#dataresult«list«jobadvertforlistdto»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobadverts/getall/forlist/byisactiveorderbycreatedatby

#### GET
##### Summary

getAllByIsActiveOrderByCreatedAtByForList

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| direction | query | direction | Yes | string |
| isActive | query | isActive | Yes | boolean |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobAdvertForListDto»»](#dataresult«list«jobadvertforlistdto»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobadverts/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobAdvert | body | jobAdvert | Yes | [JobAdvert](#jobadvert) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobadverts/update/disablebyid

#### POST
##### Summary

disableById

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | id | No | integer |

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

### /api/jobseekereducations/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerEducation | body | jobSeekerEducation | Yes | [JobSeekerEducation](#jobseekereducation) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekereducations/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerEducation | body | jobSeekerEducation | Yes | [JobSeekerEducation](#jobseekereducation) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekereducations/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerEducation»»](#dataresult«list«jobseekereducation»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekereducations/getall/byjobseekerid

#### GET
##### Summary

getAllByJobSeeker_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerId | query | jobSeekerId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerEducation»»](#dataresult«list«jobseekereducation»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekereducations/getall/byjobseekeridorderbygraduationdate

#### GET
##### Summary

getAllByJobSeeker_IdOrderByGraduationDate

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| direction | query | direction | Yes | string |
| jobSeekerId | query | jobSeekerId | Yes | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerEducation»»](#dataresult«list«jobseekereducation»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekereducations/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerEducation | body | jobSeekerEducation | Yes | [JobSeekerEducation](#jobseekereducation) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekerexperiences/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerExperience | body | jobSeekerExperience | Yes | [JobSeekerExperience](#jobseekerexperience) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekerexperiences/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerExperience | body | jobSeekerExperience | Yes | [JobSeekerExperience](#jobseekerexperience) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekerexperiences/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerExperience»»](#dataresult«list«jobseekerexperience»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekerexperiences/getall/byjobseekerid

#### GET
##### Summary

getAllByJobSeeker_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerId | query | jobSeekerId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerExperience»»](#dataresult«list«jobseekerexperience»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekerexperiences/getall/byjobseekeridorderbyquitdate

#### GET
##### Summary

getAllByJobSeeker_IdOrderByQuitDate

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| direction | query | direction | Yes | string |
| jobSeekerId | query | jobSeekerId | Yes | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerExperience»»](#dataresult«list«jobseekerexperience»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekerexperiences/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerExperience | body | jobSeekerExperience | Yes | [JobSeekerExperience](#jobseekerexperience) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
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

#### City

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | integer |  | No |
| name | string |  | No |

#### DataResult«City»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [City](#city) |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«City»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [City](#city) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«Employer»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [Employer](#employer) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobAdvertForListDto»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobAdvertForListDto](#jobadvertforlistdto) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobAdvert»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobAdvert](#jobadvert) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobPosition»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobPosition](#jobposition) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerEducation»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerEducation](#jobseekereducation) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerExperience»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerExperience](#jobseekerexperience) ] |  | No |
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
| active | boolean |  | No |
| companyName | string |  | No |
| corporateEmail | string |  | No |
| createdAt | dateTime |  | No |
| deleted | boolean |  | No |
| email | string |  | No |
| id | integer |  | No |
| password | string |  | No |
| phone | string |  | No |
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

#### JobAdvert

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| active | boolean |  | No |
| applicationDeadline | dateTime |  | No |
| city | [City](#city) |  | No |
| createdAt | dateTime |  | No |
| deleted | boolean |  | No |
| description | string |  | No |
| employer | [Employer](#employer) |  | No |
| id | integer |  | No |
| jobPosition | [JobPosition](#jobposition) |  | No |
| maxSalary | integer |  | No |
| minSalary | integer |  | No |
| numberOfOpenPositions | integer |  | No |

#### JobAdvertForListDto

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| applicationDeadline | dateTime |  | No |
| companyName | string |  | No |
| createdAt | dateTime |  | No |
| numberOfOpenPositions | integer |  | No |
| title | string |  | No |

#### JobPosition

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| active | boolean |  | No |
| createdAt | dateTime |  | No |
| deleted | boolean |  | No |
| id | integer |  | No |
| title | string |  | No |

#### JobSeeker

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| active | boolean |  | No |
| birthDate | date |  | No |
| createdAt | dateTime |  | No |
| deleted | boolean |  | No |
| email | string |  | No |
| firstName | string |  | No |
| id | integer |  | No |
| identityNumber | string |  | No |
| lastName | string |  | No |
| password | string |  | No |

#### JobSeekerEducation

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| departmentName | string |  | No |
| graduationDate | date |  | No |
| id | integer |  | No |
| jobSeeker | [JobSeeker](#jobseeker) |  | No |
| schoolName | string |  | No |
| startDate | date |  | No |

#### JobSeekerExperience

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| id | integer |  | No |
| jobPosition | [JobPosition](#jobposition) |  | No |
| jobSeeker | [JobSeeker](#jobseeker) |  | No |
| quitDate | date |  | No |
| startDate | date |  | No |
| workplaceName | string |  | No |

#### JobSeekerForRegisterDto

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| birthDate | date |  | No |
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
