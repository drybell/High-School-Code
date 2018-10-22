
$('#motorRange').change(function(e) {
    speed = document.getElementById('motorRange').value;
    console.log(speed);
    updateSpeed(speed);
});

$('#rightmotor').change(function(e) {
    speed = document.getElementById('rightmotor').value;
    console.log(speed);
    right(speed);
});



let socket = io.connect('http://' + document.domain + ':' + location.port);

socket.emit('setMode', 'in1', 'COL-AMBIENT', function (m) {
    console.log(m);
});

function on() {
    /*socket.emit('runFile', '/webProject/script.py', 'turnOn');*/
    socket.emit('runMotor', 'outB', 600);
}

function updateSpeed(speed) {
    socket.emit('runMotor', 'outB', speed);
}
function left(value) {
    socket.emit('runMotor', 'outB', value);
}
function right(value) {
    socket.emit('runMotor', 'outA', value);
}
function off() {
    /*socket.emit('runFile', '/webProject/script.py', 'turnOff');*/
    socket.emit('stopMotor', 'outB');
}
