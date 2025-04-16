# LogicGateSystem - Logic gates in Minecraft.

## Contents / Scope
- [Reason for development](#reason-for-development)
- [Design strategy](#design-strategy)
- [Implementation](#implementation)

## Reason for development
While working with multiple redstone systems, I've come to the conclusion that there are lots of missing nieche features in the current state of minecraft plugins. That's why I'd like to add these features.

## Design Strategy
This plugin will use the [default logic gate structure](https://en.wikipedia.org/wiki/Logic_gate) found in many industrial control systems, i.e. [PLCs](https://en.wikipedia.org/wiki/Programmable_logic_controller).

Most PLCs use something that is called [Boolean Algebra](https://en.wikipedia.org/wiki/Boolean_algebra), which is used to calculate the incoming and outgoing values within the logic gates.

Booleans always work with either true or false, in standard logic gate systems true is equal to 1 and false is equal to 0.

For example, when you want to make a circuit, where a piston is actuated once two buttons are pressed, you will have the following:
- If both buttons should be pressed: ```Button 1 AND Button 2``` which would be translated to ```Button 1 * Button 2```, this would be an [and gate](#and-gate)
- If just one button needs to be pressed: ```Button 1 OR Button 2```, which would be translated to ```Button 1 + Button 2```, this would be an [or gate](#or-gate)

If you keep in mind that true is equal to 1 and false is equal to 0, it would make it so the equations stated above are as follows:
- Button 1 = true, button 2 = false. ```1 * 0 = 0```, which would mean the outcome is false
- Button 1 = true, button 2 = false. ```1 + 0 = 1```, which would mean the outcome is true

More examples are listed below.

#### Truth Tables
- [AND Gate](#and-gate): Returns true if both inputs are true.
- [OR Gate](#or-gate): Returns true if at least one input is true.
- [NOT Gate](#not-gate): Returns the negation of the input.
- [NAND Gate](#nand-gate): Returns true if at least one input is false (negation of AND).
- [NOR Gate](#nor-gate): Returns true if both inputs are false (negation of OR).
- [XOR Gate](#xor-gate): Returns true if exactly one input is true.
- [XNOR Gate](#xnor-gate): Returns true if an even number of inputs are true (negation of XOR).

Truth tables for each logic gate:
##### AND Gate
| A     | B     | A AND B |
|-------|-------|---------|
| false | false | false   |
| false | true  | false   |
| true  | false | false   |
| true  | true  | true    |
##### OR Gate
| A     | B     | A OR B  |
|-------|-------|---------|
| false | false | false   |
| false | true  | true    |
| true  | false | true    |
| true  | true  | true    |
##### NOT Gate
| A     | NOT A |
|-------|-------|
| false | true  |
| true  | false |
##### NAND Gate
| A     | B     | A NAND B|
|-------|-------|---------|
| false | false | true    |
| false | true  | true    |
| true  | false | true    |
| true  | true  | false   |
##### NOR Gate
| A     | B     | A NOR B |
|-------|-------|---------|
| false | false | true    |
| false | true  | false   |
| true  | false | false   |
| true  | true  | false   |
###### XOR Gate
| A     | B     | A XOR B |
|-------|-------|---------|
| false | false | false   |
| false | true  | true    |
| true  | false | true    |
| true  | true  | false   |
###### XNOR Gate
| A     | B     | A XNOR B|
|-------|-------|---------|
| false | false | true    |
| false | true  | false   |
| true  | false | false   |
| true  | true  | true    |


## Implementation
T.B.A.