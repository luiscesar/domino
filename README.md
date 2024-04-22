# Domino
# Begin

## Description
Given in input a list of domino items, calculates the chain with the highest value that can be built starting from one of the items. The starting item is given in
input to the application, too.

## Assumptions
- The starting item has no special property, it’s just the algorithm entry point.

-  Each domino item has two values, each one ranging from 1 to 10.

-  Values on a item can’t be equal. I.e.: (4, 4) isn’t a valid item, while (2, 4) is.

- Two items can be connected in the chain if they share a common value.

- Each item can be used only once in the chain.

- When two items are connected, the common value is elided and the couple acts like
a item whose values are the non-common ones. I.e.: (1, 5) - (5, 3) is a valid
connection. To connect a third item to the chain, it must have a 1 or a 3, since the
value 5 cannot be used to extend this chain;

- The value of a chain is computed by summing the common values between
connected items. I.e.: (7, 1) - (1, 5) - (5, 3) - (3, 2) has a value of 1 + 5 + 3 = 9;

## Development
- Domino has been developed as a microservice: service, logic, model
- Domino microservice has a Restful API implementation
- Domino microservice may be deployed as a SpringBoot application
- Unit tests and integration tests realized

## Compilation
mvn clean package

## Execution
- Server side: 
   
   java -jar target\domino-1.0.0.jar

- Client side: 

   Request
   
    curl -X POST http://localhost:8080/api/dominoHighestValue
     -H "Content-Type: application/json" 
     -d "{
    "initialDominoItem": {"first": 7, "second": 1},
    "dominoItems":  [
        {"first":7, "second":1},
        {"first":1, "second":5},
        {"first":5, "second":3},
        {"first":3, "second":2}
    ]
}"

  Response

{
    "dominoChain": {
        "chain": [
            {
                "first": 1,
                "second": 7
            },
            {
                "first": 7,
                "second": 1
            },
            {
                "first": 1,
                "second": 5
            },
            {
                "first": 5,
                "second": 3
            },
            {
                "first": 3,
                "second": 7
            },
            {
                "first": 7,
                "second": 8
            }
        ],
        "leftMost": 1,
        "rightMost": 8,
        "value": 23
    }
}
