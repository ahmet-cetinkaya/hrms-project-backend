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

### /api/jobseekers/cvs/educations/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVEducation | body | jobSeekerCVEducation | Yes | [JobSeekerCVEducation](#jobseekercveducation) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/educations/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVEducation | body | jobSeekerCVEducation | Yes | [JobSeekerCVEducation](#jobseekercveducation) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekers/cvs/educations/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVEducation»»](#dataresult«list«jobseekercveducation»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/educations/getall/byjobseekercvid

#### GET
##### Summary

getAllByJobSeekerCV_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVId | query | jobSeekerCVId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVEducation»»](#dataresult«list«jobseekercveducation»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/educations/getall/byjobseekercvidorderbygraduationdate

#### GET
##### Summary

getAllByJobSeekerCV_IdOrderByGraduationDate

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| direction | query | direction | Yes | string |
| jobSeekerCVId | query | jobSeekerCVId | Yes | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVEducation»»](#dataresult«list«jobseekercveducation»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/educations/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVEducation | body | jobSeekerCVEducation | Yes | [JobSeekerCVEducation](#jobseekercveducation) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/experiences/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVExperience | body | jobSeekerCVExperience | Yes | [JobSeekerCVExperience](#jobseekercvexperience) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/experiences/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVExperience | body | jobSeekerCVExperience | Yes | [JobSeekerCVExperience](#jobseekercvexperience) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekers/cvs/experiences/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVExperience»»](#dataresult«list«jobseekercvexperience»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/experiences/getall/byjobseekercvid

#### GET
##### Summary

getAllByJobSeekerCV_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVId | query | jobSeekerCVId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVExperience»»](#dataresult«list«jobseekercvexperience»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/experiences/getall/byjobseekercvidorderbyquitdate

#### GET
##### Summary

getAllByJobSeekerCV_IdOrderByQuitDate

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| direction | query | direction | Yes | string |
| jobSeekerCVId | query | jobSeekerCVId | Yes | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVExperience»»](#dataresult«list«jobseekercvexperience»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/experiences/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVExperience | body | jobSeekerCVExperience | Yes | [JobSeekerCVExperience](#jobseekercvexperience) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/images/addandsave

#### POST
##### Summary

addAndSave

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| file | formData | file | Yes | file |
| jobSeekerCVId | query | jobSeekerCVId | Yes | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/images/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVImage | body | jobSeekerCVImage | Yes | [JobSeekerCVImage](#jobseekercvimage) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekers/cvs/images/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVImage»»](#dataresult«list«jobseekercvimage»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/images/getall/byjobseekercvid

#### GET
##### Summary

getAllByJobSeekerCV_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVId | query | jobSeekerCVId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVImage»»](#dataresult«list«jobseekercvimage»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/languages/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVLanguage | body | jobSeekerCVLanguage | Yes | [JobSeekerCVLanguage](#jobseekercvlanguage) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/languages/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVLanguage | body | jobSeekerCVLanguage | Yes | [JobSeekerCVLanguage](#jobseekercvlanguage) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekers/cvs/languages/get/byid

#### GET
##### Summary

getbyid

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | id | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«JobSeekerCVLanguage»](#dataresult«jobseekercvlanguage») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/languages/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVLanguage»»](#dataresult«list«jobseekercvlanguage»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/languages/getall/byjobseekercvid

#### GET
##### Summary

getAllByJobSeekerCV_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVId | query | jobSeekerCVId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVLanguage»»](#dataresult«list«jobseekercvlanguage»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/languages/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVLanguage | body | jobSeekerCVLanguage | Yes | [JobSeekerCVLanguage](#jobseekercvlanguage) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/skills/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVSkill | body | jobSeekerCVSkill | Yes | [JobSeekerCVSkill](#jobseekercvskill) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/skills/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVSkill | body | jobSeekerCVSkill | Yes | [JobSeekerCVSkill](#jobseekercvskill) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekers/cvs/skills/get/byid

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
| 200 | OK | [DataResult«JobSeekerCVSkill»](#dataresult«jobseekercvskill») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/skills/get/byjobseekercvid

#### GET
##### Summary

getAllByJobSeekerCV_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVId | query | jobSeekerCVId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVSkill»»](#dataresult«list«jobseekercvskill»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/skills/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVSkill»»](#dataresult«list«jobseekercvskill»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/skills/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVSkill | body | jobSeekerCVSkill | Yes | [JobSeekerCVSkill](#jobseekercvskill) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/websites/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVWebSite | body | jobSeekerCVWebSite | Yes | [JobSeekerCVWebSite](#jobseekercvwebsite) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/websites/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVWebSite | body | jobSeekerCVWebSite | Yes | [JobSeekerCVWebSite](#jobseekercvwebsite) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/jobseekers/cvs/websites/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVWebSite»»](#dataresult«list«jobseekercvwebsite»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/websites/getall/byjobseekercvid

#### GET
##### Summary

getAllByJobSeekerCV_Id

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVId | query | jobSeekerCVId | No | integer |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«JobSeekerCVWebSite»»](#dataresult«list«jobseekercvwebsite»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/jobseekers/cvs/websites/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| jobSeekerCVWebSite | body | jobSeekerCVWebSite | Yes | [JobSeekerCVWebSite](#jobseekercvwebsite) |

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

### /api/languages/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«Language»»](#dataresult«list«language»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/languages/getbyid

#### GET
##### Summary

getById

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| id | query | id | Yes | string |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«Language»](#dataresult«language») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/websites/add

#### POST
##### Summary

add

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| webSite | body | webSite | Yes | [WebSite](#website) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/websites/delete

#### DELETE
##### Summary

delete

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| webSite | body | webSite | Yes | [WebSite](#website) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [Result](#result) |
| 204 | No Content |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |

### /api/websites/get/byname

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
| 200 | OK | [DataResult«WebSite»](#dataresult«website») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/websites/getall

#### GET
##### Summary

getAll

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | [DataResult«List«WebSite»»](#dataresult«list«website»») |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

### /api/websites/update

#### POST
##### Summary

update

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| webSite | body | webSite | Yes | [WebSite](#website) |

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

#### DataResult«JobSeekerCVLanguage»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [JobSeekerCVLanguage](#jobseekercvlanguage) |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«JobSeekerCVSkill»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [JobSeekerCVSkill](#jobseekercvskill) |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«Language»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [Language](#language) |  | No |
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

#### DataResult«List«JobSeekerCVEducation»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerCVEducation](#jobseekercveducation) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerCVExperience»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerCVExperience](#jobseekercvexperience) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerCVImage»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerCVImage](#jobseekercvimage) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerCVLanguage»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerCVLanguage](#jobseekercvlanguage) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerCVSkill»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerCVSkill](#jobseekercvskill) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeekerCVWebSite»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeekerCVWebSite](#jobseekercvwebsite) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«JobSeeker»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [JobSeeker](#jobseeker) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«Language»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [Language](#language) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«List«WebSite»»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [ [WebSite](#website) ] |  | No |
| message | string |  | No |
| success | boolean |  | No |

#### DataResult«WebSite»

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| data | [WebSite](#website) |  | No |
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

#### File

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| absolute | boolean |  | No |
| absoluteFile | [File](#file) |  | No |
| absolutePath | string |  | No |
| canonicalFile | [File](#file) |  | No |
| canonicalPath | string |  | No |
| directory | boolean |  | No |
| executable | boolean |  | No |
| file | boolean |  | No |
| freeSpace | long |  | No |
| hidden | boolean |  | No |
| lastModified | long |  | No |
| name | string |  | No |
| parent | string |  | No |
| parentFile | [File](#file) |  | No |
| path | string |  | No |
| readable | boolean |  | No |
| totalSpace | long |  | No |
| usableSpace | long |  | No |
| writable | boolean |  | No |

#### InputStream

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| InputStream | object |  |  |

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

#### JobSeekerCV

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| coverLetter | string |  | No |
| createdAt | dateTime |  | No |
| educations | [ [JobSeekerCVEducation](#jobseekercveducation) ] |  | No |
| experiences | [ [JobSeekerCVExperience](#jobseekercvexperience) ] |  | No |
| id | integer |  | No |
| images | [ [JobSeekerCVImage](#jobseekercvimage) ] |  | No |
| jobSeeker | [JobSeeker](#jobseeker) |  | No |
| languages | [ [JobSeekerCVLanguage](#jobseekercvlanguage) ] |  | No |
| skills | [ [JobSeekerCVSkill](#jobseekercvskill) ] |  | No |
| webSites | [ [JobSeekerCVWebSite](#jobseekercvwebsite) ] |  | No |

#### JobSeekerCVEducation

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| departmentName | string |  | No |
| graduationDate | date |  | No |
| id | integer |  | No |
| jobSeekerCV | [JobSeekerCV](#jobseekercv) |  | No |
| schoolName | string |  | No |
| startDate | date |  | No |

#### JobSeekerCVExperience

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| id | integer |  | No |
| jobPosition | [JobPosition](#jobposition) |  | No |
| jobSeekerCV | [JobSeekerCV](#jobseekercv) |  | No |
| quitDate | date |  | No |
| startDate | date |  | No |
| workplaceName | string |  | No |

#### JobSeekerCVImage

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| id | integer |  | No |
| jobSeekerCV | [JobSeekerCV](#jobseekercv) |  | No |
| url | string |  | No |

#### JobSeekerCVLanguage

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| id | integer |  | No |
| jobSeekerCV | [JobSeekerCV](#jobseekercv) |  | No |
| language | [Language](#language) |  | No |
| level | integer |  | No |

#### JobSeekerCVSkill

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| createdAt | dateTime |  | No |
| id | integer |  | No |
| jobSeekerCV | [JobSeekerCV](#jobseekercv) |  | No |
| name | string |  | No |

#### JobSeekerCVWebSite

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| address | string |  | No |
| createdAt | dateTime |  | No |
| id | integer |  | No |
| jobSeekerCV | [JobSeekerCV](#jobseekercv) |  | No |
| webSite | [WebSite](#website) |  | No |

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

#### Language

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | string |  | No |
| name | string |  | No |

#### Resource

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| description | string |  | No |
| file | [File](#file) |  | No |
| filename | string |  | No |
| inputStream | [InputStream](#inputstream) |  | No |
| open | boolean |  | No |
| readable | boolean |  | No |
| uri | [URI](#uri) |  | No |
| url | [URL](#url) |  | No |

#### Result

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| message | string |  | No |
| success | boolean |  | No |

#### URI

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| absolute | boolean |  | No |
| authority | string |  | No |
| fragment | string |  | No |
| host | string |  | No |
| opaque | boolean |  | No |
| path | string |  | No |
| port | integer |  | No |
| query | string |  | No |
| rawAuthority | string |  | No |
| rawFragment | string |  | No |
| rawPath | string |  | No |
| rawQuery | string |  | No |
| rawSchemeSpecificPart | string |  | No |
| rawUserInfo | string |  | No |
| scheme | string |  | No |
| schemeSpecificPart | string |  | No |
| userInfo | string |  | No |

#### URL

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| authority | string |  | No |
| content | object |  | No |
| defaultPort | integer |  | No |
| deserializedFields | [URLStreamHandler](#urlstreamhandler) |  | No |
| file | string |  | No |
| host | string |  | No |
| path | string |  | No |
| port | integer |  | No |
| protocol | string |  | No |
| query | string |  | No |
| ref | string |  | No |
| serializedHashCode | integer |  | No |
| userInfo | string |  | No |

#### URLStreamHandler

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| URLStreamHandler | object |  |  |

#### WebSite

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| id | integer |  | No |
| name | string |  | No |
