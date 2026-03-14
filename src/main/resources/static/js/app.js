const API = "http://localhost:8080/produtos"

async function listarProdutos() {

    const response = await fetch(API)
    const produtos = await response.json()
    let totalProdutos = produtos.length
    let totalEstoque = 0

    produtos.forEach(produto => {
        totalEstoque += produto.quantidade
    })

    document.getElementById("totalProdutos").innerText = totalProdutos
    document.getElementById("totalEstoque").innerText = totalEstoque

    const tabela = document.getElementById("tabelaProdutos")
    tabela.innerHTML = ""

    produtos.forEach(produto => {

        tabela.innerHTML += `
        <tr>
            <td>${produto.id}</td>
            <td>${produto.nome}</td>
            <td>${produto.descricao}</td>
            <td>${produto.categoria}</td>
            <td>${produto.marca}</td>
            <td>${produto.codigo}</td>
            <td>${produto.preco}</td>
            <td>${produto.quantidade}</td>
   <td>

    <button class="btn btn-warning btn-sm" onclick="editarProduto(${produto.id})">Editar</button>
    <button class="btn btn-danger btn-sm" onclick="deletarProduto(${produto.id})">Excluir</button>

    </td>
</tr>
        `
    })
}

async function cadastrarProduto(){

    const produto = {

        nome: document.getElementById("nome").value,
        descricao: document.getElementById("descricao").value,
        categoria: document.getElementById("categoria").value,
        marca: document.getElementById("marca").value,
        codigo: document.getElementById("codigo").value,
        preco: document.getElementById("preco").value,
        quantidade: document.getElementById("quantidade").value
    }

    await fetch(API,{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(produto)
    })

    listarProdutos()
}

async function deletarProduto(id){

    await fetch(API + "/" + id,{
        method:"DELETE"
    })

    listarProdutos()
}

async function editarProduto(id){

    const nome = prompt("Novo nome do produto")
    const descricao = prompt("Nova descrição")
    const  categoria = prompt("Nova categoria")
    const marca = prompt("Nova marca")
    const codigo = prompt("Nova codigo")
    const preco = prompt("Novo preço")
    const quantidade = prompt("Nova quantidade")

    const produto = {
        nome,
        descricao,
        categoria,
        marca,
        codigo,
        preco,
        quantidade
    }

    await fetch(API + "/" + id,{
        method:"PUT",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(produto)
    })

    listarProdutos()

}

listarProdutos()
