let address = new URLSearchParams(location.search);
let productId = address.get("productId");

let generateProductDetails = function (detail) {
  let container = document.getElementById("product-details");
  let template = document
    .getElementById("product-detail-template")
    .content.cloneNode(true);

  template.querySelector(".product-img").src = detail.imageUrl;
  template.querySelector(".product-img").alt = detail.name;
  template.querySelector(
    ".product-name"
  ).textContent = `${detail.name} - ${detail.brand}`;
  template.querySelector(".product-description").textContent =
    detail.description;
  template.querySelector(
    ".product-price"
  ).textContent = `Prezzo: ${detail.price}€`;

  container.appendChild(template);
};

let getProductDetails = function () {
  fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhYzkxYzJkN2IxMTAwMTkwZTZkYjYiLCJpYXQiOjE3MDk4ODU3MjQsImV4cCI6MTcxMTA5NTMyNH0.tJVVLXS0wlwCGo8sk7Fz3NJVZ4FjH146cv1md04N1Aw", // Assicurati di sostituire YOUR_TOKEN_HERE con il tuo token reale
    },
  })
    .then((res) => {
      return res.json();
    })
    .then((productDetail) => {
      generateProductDetails(productDetail);
    });
};

getProductDetails();
