To understand functional flow of project Class Diagram and Activity diagram image is attached herewith.

Steps to execute project=>
1.Checkout master branch in your local 
2. Right Click on Project Name -> Run as -> SpringBoot App
3. Below mentioned service urls will execute after adding required data to DB and for POST need to form required requestbody.
3. Download SonarLint from marketplace to get sonar issues in local
4. To generate Sonar Report -> Download SonarQube -> execute OS Specifice SonarStart.bat file -> Register the user on SonarQube -> Generate Report


Bill Geneartion Url with all calculations after conditional discounts applicable
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you
get $ 45 as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.

http://localhost:8088/product/generate/bill

User Service Urls to add and get users for retail Store
http://localhost:8088/user/fetchbyid/9405364033

http://localhost:8088/user/save

Product Service Urls to add, delete and get products in Retail Store

http://localhost:8088/product/save

http://localhost:8088/product/deleteproduct/1

![Class_Diagram](https://github.com/Swabhi312/RetailStoreProject/assets/155736338/92ab9cc2-36d9-4ff3-984c-31cc44ce80e6)


http://localhost:8088/product/fetchbyid/2

http://localhost:8088/product/fetch/allproducts
