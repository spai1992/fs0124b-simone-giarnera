let renderProduct = function (everyProduct) {
  let row = document.getElementById("row");
  let template = document.getElementById("card-template").content;

  everyProduct.forEach((product) => {
    let newCol = template.cloneNode(true);

    newCol.querySelector("img").src = product.imageUrl;
    newCol.querySelector(".prod-name").textContent = product.name;
    newCol.querySelector(".prod-description").textContent = product.description;
    newCol.querySelector(".prod-brand").textContent = product.brand;
    newCol.querySelector(".prod-price").textContent = `${product.price}€`;

    let detailsButton = document.createElement("a");
    detailsButton.href = `./detail.html?productId=${product._id}`;
    detailsButton.className = "btn btn-primary";
    detailsButton.textContent = "Specifiche Prodotto";

    let editButton = document.createElement("a");
    editButton.href = `./edit.html?productId=${product._id}`;
    editButton.className = "btn btn-success ms-2"; //
    editButton.textContent = "Modifica";

    newCol.querySelector(".card-body").appendChild(detailsButton);
    newCol.querySelector(".card-body").appendChild(editButton);

    row.appendChild(newCol);
  });
};

let getProduct = function () {
  fetch("https://striveschool-api.herokuapp.com/api/product/", {
    headers: {
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhYzkxYzJkN2IxMTAwMTkwZTZkYjYiLCJpYXQiOjE3MDk4ODU3MjQsImV4cCI6MTcxMTA5NTMyNH0.tJVVLXS0wlwCGo8sk7Fz3NJVZ4FjH146cv1md04N1Aw",
    },
  })
    .then((res) => {
      return res.json();
    })
    .then((product) => {
      renderProduct(product);
    });
};

getProduct();
