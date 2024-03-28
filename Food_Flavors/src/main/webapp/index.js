function toggleMenu() {
    var menu = document.getElementById('menu');
    var bar = document.getElementById('menu-icon');

    if(menu.style.display === "flex"){
        menu.style.display = "none";
        bar.style.backgroundColor = "transparent";
    }
    else{
        menu.style.display = "flex";
        bar.style.backgroundColor = "gray";
    }
}


const sr = ScrollReveal({
    origin: 'top',
    distance: '30px',
    duration: '1000',
    reset: true
});

sr.reveal('.home', {delay: 200});
sr.reveal('.container', {delay: 200});
sr.reveal('.about', {delay: 200});
sr.reveal('.food', {delay: 200});
sr.reveal('.review', {delay: 200});
sr.reveal('.contact', {delay: 200});
sr.reveal('.menu', {delay: 200});


