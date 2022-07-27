/**
 * 
 */
let chrono = document.getElementById('timer');
let start = document.getElementById('butt_start');
let stop = document.getElementById('butt_stop');
let reset = document.getElementById('butt_reset');
let seconde = 0;
let minute = 0;

reset.onclick = function() {
    h1.textContent = "00:00";
    seconde = 0; minute = 0;
}