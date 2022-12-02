
# About The Project

PAYBACK, with more than 31 m customers, is the biggest loyalty program and largest multichannel marketing platform.
This project is SpringBoot project for PAYBACK Challenges whit test services for challenges.
The database that is used here is mongoDB NoSql.
project includes 2 part. the first part is for coding challenge one and the second part is for coding challeng two.

## Challenge One

### About Challenge One
First part is java code for challenge one that are in "com/business/payback/challengeOne" path. This package includes
three layer, api, database and service layer.

#### Api layer:
In api layer two packages are implemented.
Controller package include rests that getMembercoupons is in it. This api get list of member's coupon. 
Second package is dto, all of controller layer dtos are implemented here.
Controller path is "com/business/payback/challengeOne/api"

#### Database layer:
Two packages are implemented here, database entities and repositories for access to them.
Database path is "com/business/payback/challengeOne/database".

#### Service layer:
Base work of project is developed in service layer. service layer models, mapper and business services
are in this package. 
Each models that are used in service layer are here. Mapper is used for map each services models or database entities to
controller DTOs.
Service path is "com/business/payback/challengeOne/service".

#### Test 
In test class for challenge one at first step you can initialize database entities and also two methods are implemented 
for services.
Test class path is : "com/business/payback/challengeOne".

## Running 

### 1. Database setting 
Run mongodb on localhost nad 27017 port
 
### 2. Running Test 
At the first step you should run test class for initialize database entities and test service.
Run MembercouponServiceTest class.

Test 1: initCollections method for initialize database.
Test 2: getMembercouponsInvalidMemberIdTest method is for test invalid memberId. In this test an invalid memberId is sent 
to getMembercoupons api, and it's expected return ChangeSetPersister.NotFoundException.
Test 3: getMembercouponsSuccessTest method is for successful call for getMembercoupons api.

### 3. Call Rest api
For testing rest api you should call below curl :

curl --location --request GET 'localhost:8080/payback/membercoupon' \
--form 'memberId="638663b47193803dafba0000"' \
--form 'sortField="VALIDUNTIL"'

you should fill the memberId for get list of coupons for that member and also fill the sortField for sorting your list
base on nearest location or validUntil descending.

Sample result is:
[
    {
        "couponMembersId": "6387b56d03a941000c95d6b0",
        "couponId": "638663b47193803dafba5555",
        "memberId": "638663b47193803dafba0000",
        "validFrom": "2022-11-30T19:26:29.669",
        "validUntil": "2022-12-01T03:26:29.669",
        "location": {
            "x": 4.03,
            "y": 3.3,
            "type": "Point",
            "coordinates": [
                4.03,
                3.3
            ]
        }
    }
] 

couponMembersId: Each coupon that is assigned to member is in couponMembers collection and has a unique id.
couponId: Each coupon has a unique id.
memberId: Each member has a unique id.
validFrom: Each coupon has a validFrom date that coupon has validated from it.
validUntil: Each coupon has a validUntil date that coupon is validated until it.
location: Each member has location (x,y).

## Challenge Two

### About Challenge Two
A game round consists of  sending a bird to fly over the checkerboard. The checkerboard is a 2D array 15*15. when the 
bird approaches all Pointees jump to a random adjacent square so each central square has 4 neighbors and edge square has
three neighbors and corner square has two neighbors. The coupon remains on the square. At the end of each round the 
value of each coupon is determined by the number of Pointees sitting on it. The customer can redeem a coupon with its 
points after the 25th, 50th and 100th rounds. In this case it's considerd 2 model of coupon. one the them is sum af
all Pointees that are sitting on the square until now and another is number of Pointees currently.The checkerboard page 
is an array 15*15 square. In this project it's considerd a 1D array of square instead of 2D array. So in each Square we
save the index of cell in 2D array, list of neighbors number, number of current poitees, number of all Pointees that are
sitting on this square until now and number of Pointees that jump in this Pointees now . The number of cells in 2D array
for saving in 1D array is calculated by ((row * 15 ) + column). 
At the end, we show you the number Of Points Per Each coupon, the number Of Pointees Per Each coupon,the coupon with 
highest number Of Points, the coupon with highest number Of Pointees.
Path of package is "com/business/payback/challengeTwo". Package consists of two part, models and service. 

#### model
All of the models that used in challengeTwo is here. 

#### service
The main methods of game are implemented in service package.

#### Test 
In test class for challengeTwo some condition has tested.
Test class path is : "com/business/payback/challengeTne".

## Running 

### Start game
For start the game, you should run the main method in PayBackGame class in challengeTwo package. At the first you should
enter your selection of round. Be careful if you enter a invalid number you get an exception.

### Running Test
In the test class we test two condition, invalid game round and success status.

Test 1 : call PayBackGameService.startGame method for test invalid round and we exepted RuntimeException.
Test 2 : call PayBackGameService.startGame method for test success status.
