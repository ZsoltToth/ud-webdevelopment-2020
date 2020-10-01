
console.log('Hello JavaScript!');

var students = [
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

document.addEventListener(
    "DOMContentLoaded", 
    (event) => { 
        document.getElementById('title').innerText='I Love JavaScript!';
        // Original Solution
        document.getElementById('exam_results').innerText=
            "<table>..students.forEacht()..</table>";
        
        let table = document.createElement('table');
        let thead = document.createElement('thead');
        let thead_row = document.createElement('tr');
        let name_header = document.createElement('th');
        name_header.innerText = "Name";
        let result_header =document.createElement('th');
        result_header.innerText = "Result";
        thead_row.appendChild(name_header);
        thead_row.appendChild(result_header);
        thead.appendChild(thead_row);
        table.appendChild(thead);
        let tbody = document.createElement('tbody');
        table.appendChild(tbody);
        students.forEach((student)=>{
            let row = document.createElement('tr');
            let col_name  = document.createElement('td');
            let col_result  = document.createElement('td');
            col_name.innerText=student.name;
            col_result.innerText=student.score >= 50 ? "PASSED" : "FAILED";
            row.appendChild(col_name);
            row.appendChild(col_result);
            tbody.appendChild(row);

        });

        document.getElementById('exam_results').appendChild(table);

});

//Closure 
var counter = (elementId) =>{
    var counter = 0;
    return () => {
        counter += 1;
        document.getElementById(elementId).innerText=counter;
    }
}
7
//Currying
var logarithm = (base) => {
    return (x) => {
        return Math.log(x) / Math.log(base);
    }
}

var log2 = logarithm(2);
var log10 = logarithm(10);

console.log(`log_2(8) = ${log2(8)}`);


var p = new Promise(
    (resolve,reject)=>{
        setTimeout(()=>{resolve()},10000);
});
p.then(()=>{console.log('Done!')});

var waitFor = (sec) =>{
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{resolve(sec);}, sec * 1000);
    })
}

waitFor(10).then((t) => {console.log(`I have waited for ${t} secs`)});
waitFor(5).then((t) => {console.log(`I have waited for ${t} secs`)});
