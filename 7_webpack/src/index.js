
const greetings = ({name = 'World'}, callback) =>{
    callback(`Hello ${name}!`);
}

module.exports = {
    greetings : greetings
}
