# ICPC-North-America-Qualifier-2019

## Team: Bartolommeo Petrini
## Joe Walbran & Jubair Hassan

## Problem A
## Circuit Math

You are enrolled in the Computer Organization and Architecture course at your university. You decide to write a program to help check your work by computing the output value of a combinational digital circuit, given its inputs.

![Image of Circuit](/ProblemImages/A1.JPG)

Consider the circuit shown in Figure 1, which we use for illustration. This circuit has four inputs (letters A through D on the left), each of which is either true or false. There are four ‘gates’ each of which is one of three types: AND, OR, or NOT. Each gate produces either a true or false value, depending on its inputs. The last gate (the OR on the right) produces the output of the entire circuit. We can write these three types of gates in text by their equivalent logical operators: * for AND, + for OR, and - for NOT. In what follows, we’ll use the operators rather than gates to describe circuits.

Here is how these operators work. Given an assignment of true (T) or false (F) for each input, the operators produce the truth value indicated in the following tables:

![Image of Truth Tables](/ProblemImages/A2.JPG)

Notice that AND and OR take two inputs, whereas NOT operates on only one input. Also, we use postfix notation to write expressions involving operators **(like A B *)**, where the operator comes after its input(s) (just as how in Figure 1, each gate in the circuit diagram comes after its inputs).

When we describe a valid circuit in postfix notation, we use the following syntax.

- An uppercase letter (A through Z) is a valid circuit. In other words, an input alone (without any gates) is a valid circuit (which produces as output its own input value).

- If <C1> and <C2> are valid circuits, then ‘<C1> <C2> *’ is a valid circuit that produces the AND of the outputs of the two subcircuits.

- If <C1> and <C2> are valid circuits, then ‘<C1> <C2> +’ is a valid circuit that produces the OR of the outputs of the two subcircuits.

- If <C1> is a valid circuit, then ‘<C1> -’ is a valid circuit that produces the NOT of <C1>’s output.

No other description is a valid circuit.

Thus, one of the ways the circuit in Figure 1 could be described using postfix notation is as the string:

    A B * C D + - +

Given a truth value (T or F) for each of the inputs (A, B, C, and D in this example), their values propagate through the gates of the circuit, and the truth value produced by the last gate is the output of the circuit. For example, when the above circuit is given inputs A=T, B=F, C=T, D=F, the output of the circuit is F.

Given an assignment to variables and a circuit description, your software should print the output of the circuit.

### Input

The first line of the input consists of a single integer **n**, satisfying **1≤n≤26**, denoting the number of input variables. Then follows a line with **n** space-separated characters. Each character is either **T** or **F**, with the ith such character indicating the truth value of the input that is labeled with the *i*th letter of the alphabet.

The last line of input contains a circuit description, which obeys the syntax described above. Each circuit is valid, uses only the first **n** letters of the alphabet as input labels, and contains at least **1** and at most **250** total non-space characters.

Note that while each variable is provided only one truth value, a variable may appear multiple times in the circuit description and serve as input to more than one gate.

### Output

Print a single character, the output of the circuit (either **T** or **F**), when evaluated using the given input values.

![Image of Output](/ProblemImages/A3.JPG)


## Problem B
## Diagonal Cut

Quido and Hugo are making a chocolate cake. The central ingredient of the cake is a large chocolate bar, lying unwrapped on the kitchen table. The bar is an **M×N** rectangular grid of chocolate blocks. All of the **M N** blocks are rectangles of identical shape and size. The chocolate bar is of top quality and the friends want to eat part of it, before the rest is used in the cake.

“OK,” says Quido, “let’s divide the whole bar into two triangular chunks by a straight diagonal cut from its upper-left corner to its lower-right corner. We will then eat all of the blocks which have been cut exactly in half, into two equal-area pieces. You will eat one half and I will eat the other half of each such block. All other blocks, that is, the blocks which are either uncut or cut into two parts of different sizes, will go directly into the cake. Of course, we will make sure the cut is perfectly precise.

Let’s see how much chocolate we get to eat!”

### Input

The input consists of two space-separated integers **M** and **N** given on a single line, (where **1≤M,N≤10**<sup>**18**</sup>). The numbers **M** and **N** denote the number of blocks in one column and in one row, respectively, in the chocolate bar.

### Output

Print the number of blocks of the chocolate bar which are cut into exactly two pieces of equal area.

![Image of Output2](/ProblemImages/B1.JPG)


## Problem C
## Gerrymandering

Electoral systems across the world can vary widely. In some systems, such as *winner-take-all*, the winner is determined by the plurality of votes—the candidate that receives the most votes wins, and the loser(s) do not get a position.

Such elections can have “wasted votes.” Conceptually, a wasted vote is a vote that did not affect the election outcome. While the exact definition of a wasted vote varies, we’ll adopt the following definition: in an election with **V** voters, every vote for a losing candidate is wasted (these are called lost votes), and every vote for a winning candidate beyond the strict majority of **⌊V/2⌋+1** votes the candidate needs to win is wasted (these are called excess votes). For this problem we’ll consider a two-party system (let’s call the parties A and B) with elections that always involve one candidate from each party.

Let’s illustrate wasted votes with a simple example between two candidates in a district. Suppose that the candidate for party A receives **100** votes and the candidate for party B receives **200** votes. All **100** votes for party A are wasted (lost votes for A), and **49** votes for party B are wasted (excess votes for B). This is because B needs **151 (⌊(100+200)/2⌋+1)** votes to win (over A), so the remaining 49 are wasted.

Political scientists use wasted votes to compute the efficiency gap, a single number that summarizes wasted votes. Suppose we have a number of races in different districts, where each district elects one person. Across all districts there are **V** total votes cast, with **w<sub>**A**</sub>** total wasted votes for party **A** and **w<sub>**B**</sub>** total wasted votes for party B. Then the efficiency gap is:

![Image of Equation](/ProblemImages/C1.JPG)

A low efficiency gap indicates that the elections are competitive, and that the number of candidates elected from each party is representative of the total voting share for each party. When the efficiency gap is high, this can be an indication of gerrymandering. Gerrymandering refers to organizing voting districts in a way that favors a particular political outcome. Two common ways of doing this are to “pack” similar voters into districts, or “crack” them across multiple districts; both ways tend to diminish those voters’ influence in electing candidates they would like to win.

In an election, districts are made up of precincts. A precinct is an indivisible group of voters. The votes for all precincts in a district are added together to find the results for that district. In this problem you are given a description of a number of precincts: the party vote totals for each precinct, and how those precincts have been grouped into districts. For each district, determine the party that wins and the wasted votes for each party. Then determine the efficiency gap between the two parties over all the districts.

### Input

The input describes one election. The first line contains two integers **P** and **D**, where **1≤P≤10000** and **1≤D≤min(1000,P)**. These indicate, respectively, the number of voting precincts and districts. Following this are **P** lines describing the precincts. Line *i* contains **3** numbers: the district **d<sub>**i**</sub>** that precinct *i* is assigned to **(1≤d<sub>**i**</sub>≤D)**, the number of votes for the candidate from party A **(0≤a<sub>**i**</sub>≤100000)**, and the number of votes for the candidate from party B **(0≤b<sub>**i**</sub>≤100000)**. It is guaranteed that:

- for each precinct *i*, **0<a<sub>**i**</sub>+b<sub>**i**</sub>**,

- each district is assigned at least one precinct, and

- there are no ties within any district.

### Output

For each of the districts from **1** to **D**, print which party wins (a single character, either A or B). Then print the number of wasted votes for party A and for party B, in order. Finally, after reporting on all the districts, print the efficiency gap as measured over all the districts. The efficiency gap should be accurate to within an absolute error of **10<sup>-6</sup>**.

![Image of Output3](/ProblemImages/C2.JPG)


## Problem D
## Missing Numbers

You enjoy your new job as a teacher of young children. It’s fun to see them learning to count, recognize letters, draw, and interact with the world.

One common problem you’ve noticed is that children often forget numbers when counting. For example, early on they might count “one, two, three, five, six.” You have to remind them about that “four” that they didn’t say. And as they get more proficient and clever, they may use the “quick” way of counting: “one, two, skip a few, ninety-nine, one hundred!”

Please write a program that can help you (and your students) identify the missing numbers when they are counting.

### Input

The first line of input contains a single integer **n**, where **1≤n≤100**. Each of the next **n** lines contains one number that the child recited. Each recited number is an integer between **1** and **200** (inclusive). They are listed in increasing order, and there are no duplicates.

### Output

If the child recited all the numbers between **1** and the last number they recited, then print good job.

If the child missed any numbers between **1** and the last number they recited, then print those missing numbers in increasing numeric order, one per line.

![Image of Output4](/ProblemImages/D1.JPG)
