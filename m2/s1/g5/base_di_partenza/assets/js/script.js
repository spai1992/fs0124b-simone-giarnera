let colorTopBar = document.querySelector(".top-navbar");
let colorButton = document.querySelector("#navbar-button");

window.addEventListener("scroll", function () {
  let top = window.scrollY;
  if (top >= 350) {
    colorTopBar.style.backgroundColor = "#FFFFFF";
    colorButton.style.backgroundColor = "#1A8916";
  } else {
    colorTopBar.style.backgroundColor = "#FFC017";
    colorButton.style.backgroundColor = "#191919";
  }
});
