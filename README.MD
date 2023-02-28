
# Bank Account Management MircroService

This project contains several microservices which combines together to form the whole customer account management app.

### Below is the list of diffrent microservice along with their port no. on localhost:
1. Eureka Service or Discovery Service - localhost:8761 (http://localhost:8761)
2. API Gateway - localhost:8083 (http://localhost:8083)
3. Config Server - localhost:8084 (http://localhost:8084)
4. Account Management Service - localhost:8082 (http://localhost:8082)
5. Customer Management Service - localhost:8081 (http://localhost:8081)

#### Note : You can access all these api on their localhost port and details of all the api is given below. 



## How to run this project

Please follow the steps to run this project: 

* Download or clone souce code in your machine
* Open all the projects in Eclipse or Intellij id as maven projects
* After updating all maven projects run all of them as spring boot app in following order.
    * Discovery Server
    * API Gateway
    * Account Service
    * Customer Service
* Open url (http://localhost:8761) and eureka server dashboard will be open and you can see all remaining services are registered on eureka server.


## API Reference


#### Get all accounts

```http
  GET /accounts
```

#### Add  new account

```http
  POST /account/addAccount
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `balance` | `int` | **Optional**. Initial Balance |

##### Note : Pass all these  parameters in a json file as post request accepts json file only.

#### Add  multiple account

```http
  POST /account/addAccounts 
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `balance` | `int` | **Optional**. Initial Balance |

##### Note : Pass all these parameters in a json file as an array of json objects as post request accepts json file only.

#### Update an account

```http
  Put /account/updateAccount
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `balance` | `int` | **Optional**. Updated Balance |

##### Note : Pass all these parameters in a json file as put request accepts json file only.

#### Get account by account_no

```http
  GET /account/${accountNo}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Your account number for which details is to be fetched |

#### Add Money to account

```http
  PUT /account/addMoney
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `money` | `int` | **Required**. Amount to be added in account |

##### Note : Pass all these both parameters in a json file as put request accepts json file only.

#### Withdraw Money from account

```http
  PUT /account/withdrawMoney
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `money` | `int` | **Required**. Amount to be withdraw from account |

##### Note : Pass all these both parameters in a json file as put request accepts json file only.

#### Delete an account

```http
  DELETE /account/${accountNo}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Your account to be deleted |


#### Get all customers

```http
  GET /customers
```

#### Add new customer

```http
  POST /customer/addCustomer
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `firstName` | `String` | **Required**. Customer First Name |
| `lastName` | `String` | **Required**. Customer Last Name |
| `dob` | `String` | **Required**. Customer Date of Birth |

##### Note : Pass all these  parameters in a json file as post request accepts json file only.

#### Add multiple customers

```http
  POST /customer/addCustomer
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `firstName` | `String` | **Required**. Customer First Name |
| `lastName` | `String` | **Required**. Customer Last Name |
| `dob` | `String` | **Required**. Customer Date of Birth |

##### Note : Pass all these  parameters in list of json objects as post request accepts json file only.

#### Update a customer

```http
  Put /customer/updateCustomer
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `accountNo` | `int` | **Required**. Account Number |
| `customerId` | `int` | **Required**. Customer Id |
| `firstName` | `String` | **Required**. Customer First Name |
| `lastName` | `String` | **Required**. Customer Last Name |
| `dob` | `String` | **Required**. Customer Date of Birth |

##### Note : Pass all these parameters in a json file as put request accepts json file only .

#### Get customer by customer id

```http
  GET /customer/${customerId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `customerId` | `int` | **Required**. Customer id whose details to be fetched |

#### Delete a customer

```http
  DELETE /customer/${customerId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `customerId` | `int` | **Required**. Customer id to be deleted |

#### Note : Use localhost:8081 (http://localhost:8081) to access all Customer Service api request and  use localhost:8082 (http://localhost:8082) to access all account services api.

#### Note : As we are using api gateway, so we can use api gateway localhost:8083 (http://localhost:8083) to access all the api listed above.