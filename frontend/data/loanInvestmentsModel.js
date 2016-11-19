var mongoose    = require('mongoose');
mongoose.connect('mongodb://localhost/testdb');
var db = mongoose.connection;

db.on('error', function (err) {
    console.error('connection error:', err.message);
});
db.once('open', function callback () {
    console.log("Connected to DB!");
});

var Schema = mongoose.Schema;

var Proposition = new Schema({
    id: { type: String, required: true },
    title: { type: String, required: true },
    disc: { type: String, required: true },
    sum: { type: Number, required: true },
    isClosed: { type: Boolean, required: true }
});

var User = new Schema({
    login: { type: String, required: true },
    dsignature: { type: String, required: true },
    bguid: { type: String, required: true },
    password: { type: String, required: true },
    propositions: [Proposition]
});

var PropositionModel = mongoose.model('Proposition', Proposition);
var UserModel = mongoose.model('User', User);

module.exports = {
    UserModel: UserModel,
    PropositionModel: PropositionModel
};