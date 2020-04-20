'use strict';
var express = require('express');
var cors = require('cors');
var bodyParser = require('body-parser');
var app = express();
var router = express.Router();


app.listen(3000, () => {
    console.log('server is running on port 3000')
});

app.use('/', router);

router.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization');
    if (req.method === 'OPTIONS') {
        res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization');
        res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, PATCH');
        return res.status(200).json({});
    };
    next();
});
    

//router.use(cors());
router.use(bodyParser.urlencoded({extended: false}));
router.use(bodyParser.json());

router.get('/', (req,res) =>{
    res.send('Hey there!!! Hi from a Server!!!!');
    res.end();
});

router.post('/enroll', (req, res) => {
    console.log(req.body);
    res.status(200).send({'message' : 'Data Recieved Succssfully'});
    //res.status(401).send({'message' : 'Un-Authorized'});
});