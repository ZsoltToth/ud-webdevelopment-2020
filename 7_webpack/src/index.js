const {submit : submitOrder} = require('./orders')

const greetings = ({name = 'World'}, callback) =>{
    callback(`Hello ${name}!`);
}

module.exports = {
    greetings : greetings,
    submitOrder : submitOrder
}
