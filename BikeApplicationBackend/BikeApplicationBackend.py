
# sudo pip3 install Flask-PyMongo
# sudo pip3 install pymongo[srv]
# sudo pip3 install flask-socketio
# sudo pip3 install eventlet


# from flask import Flask, render_template,  request, escape
# from flask_socketio import SocketIO, emit
# from flask_pymongo import PyMongo
# from bson.json_util import dumps, loads 

from flask import Flask, render_template,  request, escape, jsonify, url_for
from flask_socketio import SocketIO, emit
from flask_pymongo import PyMongo
from bson.json_util import dumps, loads 
from pymongo import MongoClient
from bson.objectid import ObjectId

app = Flask(__name__)
app.config['SECRET_KEY'] = 'someSecretKey123'
app.config['DEBUG'] = True

socketio = SocketIO(app)
users = {}

app.config["MONGO_URI"] = "mongodb+srv://backend:backend@cluster0.rxm7h.mongodb.net/BikeRentalDB?retryWrites=true&w=majority" # replace the URI with your own connection
mongo = PyMongo(app)


@app.route('/')
def init():                            # this is a comment. You can create your own function name
    return '''
        FOR TESTING
        <form method="POST" action="/addbike" enctype="multipart/form-data">
            Brand <input type="text" name="brand">
            UserType<input type="text" name="userType">
            BikeType<input type="text" name="bikeType">
            Price<input type="text" name="price">
            UserComments<input type="text" name="userComments">
            UserRating<input type="text" name="userRating">
            Photo<input type="file" name="bike_image">
            Description<input type="text" name="description">
            <input type="submit">
        </form>
    '''
    
@app.route('/addbike2', methods=['POST'])
def addbike2():
    if 'bike_image' in request.files:
        bike_image = request.files['bike_image']
        mongo.save_file(bike_image.filename, bike_image)
        mongo.db.BikeList.insert({'Brand' : request.form.get('brand'), 
            'UserType' : request.form.get('userType'),
            'BikeType' : request.form.get('bikeType'), 
            'Price' : request.form.get('price'),
            'Status' : request.form.get('status',"Available"),
            'UserComments' : request.form.get('userComments'),
            'UserRating' : request.form.get('userRating'),
            'Photo' : bike_image.filename,
            'Description' : request.form.get('description'),
        })
        
    return 'Done!'

    
@app.route("/brand/<brand>")
def brand(Brand):
    bikepicture = mongo.db.BikeList.find_one_or_404({'Brand' : Brand})
    return f'''
        <h1>{Brand}<h1>
        <img src = "{url_for('file', filename=bikepicture['bike_image'])}">
    '''
    
@app.route("/addbike1", methods=['POST'])
def addbike1():
    _json = request.json
    # print(_json, flush=True)
    _UserType = 'UserType'
    _BikeType = 'BikeType'
    _Price = 'Price'
    _Status = 'Status'
    _UserComments = 'UserComments'
    _UserRating = 'UserRating'
    _Photo = request.files['bike_image']
    _Description = 'Password'

    if _UserType and _BikeType and _Price and _Status and _UserComments and _UserRating and _Photo and _Description and request.method == 'POST':
        mongo.save_file(_Photo.filename, _Photo)
        id = mongo.db.UserList.insert_one(
            {'UserType': _UserType, 'BikeType': _BikeType, 'Price': _Price , 'Status': _Status, 'UserComments':_UserComments, 'UserRating': _UserRating, 'Photo':_Photo, 'Description':_Description})
        resp = jsonify("user added successfully")
        resp.status_code = 200
        return resp

@app.route("/addbike", methods=['POST'])
def addbike():
    _json = request.json
    # print(_json, flush=True)
    _VendorName = _json['VendorName']
    _Brand = _json['Brand']
    _BikeType = _json['BikeType']
    _UserType = _json['UserType']
    _Description = _json['Description']
    _PickupLocation = _json['PickupLocation']
    _Price = _json['Price']

    if _VendorName and _Brand and _BikeType and _UserType and _Description and _PickupLocation and _Price and request.method == 'POST':
        id = mongo.db.BikeList.insert_one(
            {'VendorName': _VendorName, 'Brand': _Brand , 'BikeType': _BikeType , 'UserType': _UserType, 'Description':_Description, 'PickupLocation':_PickupLocation, 'Price':_Price})
        resp = jsonify("user added successfully")
        resp.status_code = 200
        return resp    
        
        
@app.route("/addbookinghistory", methods=['POST'])
def addbookinghistory():
    _json = request.json
    # print(_json, flush=True)
    _FullName = _json['FullName']
    _UserName = _json['UserName']
    _BikeBrand = _json['BikeBrand']
    _VendorName = _json['VendorName']
    _AmountPaid = _json['AmountPaid']
    _PickupLocation = _json['PickupLocation']

    if _FullName and _UserName and _BikeBrand and _VendorName and _AmountPaid and _PickupLocation and request.method == 'POST':
        id = mongo.db.BookingHistory.insert_one(
            {'FullName': _FullName, 'UserName': _UserName , 'BikeBrand': _BikeBrand , 'VendorName': _VendorName, 'AmountPaid':_AmountPaid, 'PickupLocation': _PickupLocation})
        resp = jsonify("bookinghistory added successfully")
        resp.status_code = 200
        return resp
        
@app.route("/findbookingbyusername/<username>")
def findbookingbyusername(username):
    return dumps(mongo.db.BookingHistory.find_one({'UserName': username}))
        
    
@app.route("/adduser", methods=['POST'])
def adduser():
    _json = request.json
    # print(_json, flush=True)
    _FullName = _json['FullName']
    _UserName = _json['UserName']
    _Address = _json['Address']
    _Password = _json['Password']

    if _FullName and _UserName and _Address and _Password and request.method == 'POST':
        id = mongo.db.UserList.insert_one(
            {'FullName': _FullName, 'UserName': _UserName , 'Address': _Address , 'Password': _Password})
        resp = jsonify("user added successfully")
        resp.status_code = 200
        return resp
    

@app.route('/getallusers')
def getallusers():
    user =mongo.db.UserList.find();
    
    userList = list(user)
    return dumps(userList)
    
@app.route("/getallbikes")
def getallbikes():
    bikes = mongo.db.BikeList.find()
    resp = dumps(bikes)
    return resp
    
@app.route("/getbikedescription/<id>")
def get_single(id):
    bike = mongo.db.BikeList.find_one({'_id': ObjectId(id)})
    resp = dumps(bike)
    return resp
    
@app.route("/findusernamepassword/<username>")
def findusernamepassword(username):
    return dumps(mongo.db.UserList.find_one({'UserName': username}))
    
if __name__ == '__main__':
    socketio.run(app,host = '0.0.0.0')  # here, we are using socketio instaead of app because it has more features
