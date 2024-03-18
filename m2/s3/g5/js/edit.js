let address = new URLSearchParams(location.search);
let productId = address.get("productId");
let form = document.getElementById("edit-product-form");

fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
  headers: {
    Authorization:
      "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhYzkxYzJkN2IxMTAwMTkwZTZkYjYiLCJpYXQiOjE3MDk4ODU3MjQsImV4cCI6MTcxMTA5NTMyNH0.tJVVLXS0wlwCGo8sk7Fz3NJVZ4FjH146cv1md04N1Aw",
  },
})
  .then((res) => res.json())
  .then((data) => {
    document.getElementById("name").value = data.name;
    document.getElementById("description").value = data.description;
    document.getElementById("brand").value = data.brand;
    document.getElementById("imgUrl").value = data.imageUrl;
    document.getElementById("price").value = data.price;
  });

form.addEventListener("submit", function (e) {
  e.preventDefault();
  let editedProduct = {
    name: document.getElementById("name").value,
    description: document.getElementById("description").value,
    brand: document.getElementById("brand").value,
    imageUrl: document.getElementById("imgUrl").value,
    price: document.getElementById("price").value,
  };

  fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhYzkxYzJkN2IxMTAwMTkwZTZkYjYiLCJpYXQiOjE3MDk4ODU3MjQsImV4cCI6MTcxMTA5NTMyNH0.tJVVLXS0wlwCGo8sk7Fz3NJVZ4FjH146cv1md04N1Aw",
    },
    body: JSON.stringify(editedProduct),
  }).then(() => {
    alert("Prodotto aggiornato con successo");
    window.location.href = "index.html";
  });
});

let deleteButton = document.createElement("button");
deleteButton.textContent = "Elimina";
deleteButton.className = "btn btn-danger";
deleteButton.type = "button";
form.appendChild(deleteButton);

deleteButton.addEventListener("click", function () {
  if (confirm("Sei sicuro di voler eliminare questo prodotto?")) {
    fetch(`https://striveschool-api.herokuapp.com/api/product/${productId}`, {
      method: "DELETE",
      headers: {
        Authorization:
          "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhYzkxYzJkN2IxMTAwMTkwZTZkYjYiLCJpYXQiOjE3MDk4ODU3MjQsImV4cCI6MTcxMTA5NTMyNH0.tJVVLXS0wlwCGo8sk7Fz3NJVZ4FjH146cv1md04N1Aw",
      },
    }).then((res) => {
      alert("Prodotto eliminato con successo");
      window.location.href = "index.html";
    });
  }
});
