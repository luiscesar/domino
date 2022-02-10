# Domino

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
