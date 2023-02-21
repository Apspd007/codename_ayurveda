
const text1 = 'The Mythology, as told in the Caraka Samhita (the greatest of all classical texts on Ayurveda), tells that about 5,000 years ago a group of great rishis sat together on the slopes of the Himalayan Mountains.';

const text2 = 'Ayurveda is one among the seven Ayush systems and is referred to as the science of life. For years, it has been a key part of a comprehensive natural healthcare system in India.';

const data = [text1, text2];

let index = 0;

const image = document.getElementById("hero-image");
const image_text = document.getElementById("image-text");
const next_btn = document.getElementById("next-btn")
const previous_btn = document.getElementById("previous-btn")

next_btn.addEventListener('click', nextImage);
previous_btn.addEventListener('click', previousImage);

function nextImage() {
    if (index < (data.length - 1)) index++;

    image.style.backgroundImage = `url('images/hero-images/image-${index + 1}.png')`;
    image_text.innerText = data[index];
}

function previousImage() {
    if (index != 0) index--;

    image.style.backgroundImage = `url('images/hero-images/image-${index + 1}.png')`;
    image_text.innerText = data[index];
}


function init() {
    image.style.backgroundImage = `url('images/hero-images/image-${index + 1}.png')`;
    image_text.innerText = data[index];
}


function redirectHome() {
    document.location.href = "/codename-ayurveda";
}

function blankRedirect(n) {
    window.open(n, '_blank');
}
