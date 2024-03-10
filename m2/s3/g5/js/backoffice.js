let form = document.getElementById("form");

form.addEventListener("submit", function (x) {
  x.preventDefault();

  let newProduct = {
    name: document.getElementById("name").value,
    description: document.getElementById("description").value,
    brand: document.getElementById("brand").value,
    imageUrl: document.getElementById("imgUrl").value,
    price: document.getElementById("price").value,
  };

  fetch("https://striveschool-api.herokuapp.com/api/product/", {
    method: "POST",
    body: JSON.stringify(newProduct),
    headers: {
      "Content-Type": "application/json",
      Authorization:
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhYzkxYzJkN2IxMTAwMTkwZTZkYjYiLCJpYXQiOjE3MDk4ODU3MjQsImV4cCI6MTcxMTA5NTMyNH0.tJVVLXS0wlwCGo8sk7Fz3NJVZ4FjH146cv1md04N1Aw", // Inserisci il token di autenticazione
    },
  })
    .then((res) => res.json())
    .then((res) => {
      window.location.href = "index.html";
    });
});
