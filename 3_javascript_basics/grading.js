/*

Task 1:
 Print the results if the max score is 100 and the passed above 50 points (inclusive).

 Expected result:
 Alice Failed
 Bob Failed
 Charlie Passed

 Task 2: Grade them properly and print the grades as well.
 [0,50) ->  1
 [50,60] -> 2
 [60,80] -> 3
 [80,90) -> 4
 [90,100] -> 5

 Expected Results
2: {name: "Charlie", score: 98, mark: 5}
3: {name: "Denis", score: 78, mark: 3}
4: {name: "Eve", score: 56, mark: 2}
5: {name: "Frank", score: 14, mark: 1}
6: {name: "Gabe", score: 49, mark: 1}
7: {name: "Hugo", score: 39, mark: 1}
8: {name: "Ivan", score: 100, mark: 5}

 Task 3: Grade them according to a Curve std=10

1: {name: "Bob", score: 39, mark: 1, curvedGrade: 3}
2: {name: "Charlie", score: 98, mark: 5, curvedGrade: 5}
3: {name: "Denis", score: 78, mark: 3, curvedGrade: 4}
4: {name: "Eve", score: 56, mark: 2, curvedGrade: 3}
5: {name: "Frank", score: 14, mark: 1, curvedGrade: 1}
6: {name: "Gabe", score: 49, mark: 1, curvedGrade: 3}

Question: Who get other grade due to the curve?


 Task 4: Generate HTML table from the above results
 ...

See also: 
 - https://www.thoughtco.com/grading-on-a-curve-3212063#:~:text=Grading%20on%20a%20curve%20is,perhaps%20increasing%20the%20letter%20grade.
 - https://en.wikipedia.org/wiki/Relative_grading
*/

var scores = [
    {
        name : 'Alice',
        score : 32
    },
    {
        name : 'Bob',
        score : 39
    },
    {
        name : 'Charlie',
        score : 98
    },
    {
        name : 'Denis',
        score : 78
    },
    {
        name : 'Eve',
        score : 56
    },
    {
        name : 'Frank',
        score : 14
    },
    {
        name : 'Gabe',
        score : 49
    },
    {
        name : 'Hugo',
        score : 39
    },
    {
        name : 'Ivan',
        score : 100
    },
    {
        name : 'John',
        score : 43
    },
    {
        name : 'Kevin',
        score : 65
    },
    {
        name : 'Lousie',
        score : 54
    },
    {
        name : 'Maria',
        score : 63
    },
    {
        name : 'Nate',
        score : 65
    },
    {
        name : 'Oliver',
        score : 12
    },
    {
        name : 'Pedro',
        score : 87
    },
    {
        name : 'Rebeca',
        score : 83
    },
    {
        name : 'Sarah',
        score : 29
    },
    {
        name : 'Tamara',
        score : 73
    },
    {
        name : 'Wade',
        score : 5
    },
]