const axios = require('axios');
const validate = ({age}) =>{
    return age >= 18;
}

const submitOrder = (customer, success, failure) =>{
    if(!validate(customer)){
        failure();
        return;
    }
    success();
}

const listOrders = (callback) => {
    axios.get('orders.json').then(({data})=>{
        callback(data);
    });
}

const _createTableHeaderCell = (text) =>{
    const result = document.createElement('th');
    result.textContent = text;
    return result;
}

const _createTableDataCell = (text) =>{
    const result = document.createElement('td');
    result.textContent = text;
    return result;
}

const _createTableRowForOrder = ({orderId, customer, products}) => {
    const result = document.createElement('tr');
    result.appendChild(_createTableDataCell(orderId));
    result.appendChild(_createTableDataCell(customer.name));
    result.appendChild(_createTableDataCell(products));
    return result;
}

const printOrdersInTable = (rootNode) =>{
    const table = document.createElement('table');
    const tableHeader = document.createElement('tr');
    tableHeader.appendChild(_createTableHeaderCell('ID'));
    tableHeader.appendChild(_createTableHeaderCell('Customer'));
    tableHeader.appendChild(_createTableHeaderCell('Products'));
    table.appendChild(tableHeader);
    listOrders((orders) => {
        orders.forEach((order) => {
            table.appendChild(_createTableRowForOrder(order));
        });
    })
    rootNode.appendChild(table);
}

module.exports = {
    _validate : validate,
    submit : submitOrder,
    list : printOrdersInTable
}
