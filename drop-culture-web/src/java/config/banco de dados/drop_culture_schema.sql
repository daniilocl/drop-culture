-- ============================================================================
-- Drop Culture — Script de Criação do Banco de Dados e Tabelas
-- SGBD: MySQL / MariaDB (XAMPP) | Charset: utf8mb4
-- ============================================================================

CREATE DATABASE IF NOT EXISTS drop_culture
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE drop_culture;

-- ----------------------------------------------------------------------------
-- 1. Tabela: categoria (11 campos)
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    slug VARCHAR(120) NOT NULL UNIQUE,
    descricao TEXT,
    publico_alvo VARCHAR(60),
    estilo VARCHAR(60),
    imagem_url VARCHAR(255),
    ativa BOOLEAN NOT NULL DEFAULT TRUE,
    ordem_exibicao INT NOT NULL DEFAULT 0,
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------------------------------------
-- 2. Tabela: produto (15 campos)
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT NOT NULL,
    sku VARCHAR(40) NOT NULL UNIQUE,
    nome VARCHAR(150) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    tamanho_br VARCHAR(10) NOT NULL,
    cor VARCHAR(60),
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL DEFAULT 0,
    imagem_url VARCHAR(255),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_produto_categoria
        FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------------------------------------
-- 3. Tabela: cliente (16 campos)
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    sobrenome VARCHAR(120) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(25),
    cpf VARCHAR(14) NOT NULL UNIQUE,
    cep VARCHAR(9),
    logradouro VARCHAR(150),
    numero VARCHAR(15),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf CHAR(2),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------------------------------------
-- 4. Tabela: vendedor (13 campos)
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS vendedor (
    id_vendedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    sobrenome VARCHAR(120) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(25),
    matricula VARCHAR(30) NOT NULL UNIQUE,
    cargo VARCHAR(80),
    data_admissao DATE,
    turno VARCHAR(30),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    observacoes VARCHAR(255),
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------------------------------------
-- 5. Tabela: pedido (13 campos)
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    id_vendedor INT NOT NULL,
    numero_pedido VARCHAR(30) NOT NULL UNIQUE,
    data_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(30) NOT NULL DEFAULT 'PENDENTE',
    subtotal DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    desconto DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    valor_total DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    forma_pagamento VARCHAR(40),
    observacoes TEXT,
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_pedido_cliente
        FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT fk_pedido_vendedor
        FOREIGN KEY (id_vendedor) REFERENCES vendedor (id_vendedor)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------------------------------------------------------
-- 6. Tabela: item_pedido (11 campos)
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS item_pedido (
    id_item_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    sku_snapshot VARCHAR(40) NOT NULL,
    descricao_snapshot VARCHAR(150) NOT NULL,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    desconto_unitario DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    subtotal DECIMAL(10, 2) NOT NULL,
    criado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_item_pedido_pedido
        FOREIGN KEY (id_pedido) REFERENCES pedido (id_pedido)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT fk_item_pedido_produto
        FOREIGN KEY (id_produto) REFERENCES produto (id_produto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
