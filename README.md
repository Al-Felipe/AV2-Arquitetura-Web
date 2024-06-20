# Sistema de Autenticação

## Objetivo
Implementar um sistema de microsserviço de autenticação segura utilizando JSON Web Tokens (JWT), 
permitindo acesso aos endpoints  de acordo com o nível de permissão do usuário podendo este ser
(ADMIN, GERENTE, VENDEDOR E CLIENTE).

## Diagrama de Microsserviços

<img width="6000" alt="Diagrama" src="https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/2a12435a-7486-487f-806a-982a82bbbfd8">

## Endpoints Disponíveis

**POST** /login: Endpoint de autenticação para obter token JWT.

Endpoint: https://exemplo.com/login

![post login](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/364ce6cd-69b1-441f-a52d-4ff38f952546)

**GET** /username/{token}: Retorna o nome do usuário a partir do token JWT.

Endpoint: https://exemplo.com/username/{token}

![username](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/b20f9ecb-151f-43c4-b2db-784936e37a72)

**GET** /admin/user: Retorna informações que somente o admin pode acessar.

Endpoint: https://exemplo.com/admin/user

![get admin user](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/67516f6b-f4e4-4a2b-98b4-cfb531c3e5ae)

**GET** /gerente/produtos: Retorna informações que somente o gerente pode acessar.

Endpoint: https://exemplo.com//gerente/produtos

![gerente produtos](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/b7d3d09e-759a-4886-b055-f362d390977d)

**GET** /vendedor/pedidos: Retorna informações que somente o vendedor pode acessar.

Endpoint: https://exemplo.com//vendedor/pedidos

![vendedor pedidos](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/a74493a6-984b-48f6-ade9-6c917cc54b9d)

**GET** /cliente/produtos: Retorna informações que somente o cliente pode acessar.

Endpoint: https://exemplo.com///cliente/produtos

![cliente produtos](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/b0ec9f72-89d9-406a-836c-6cc4f7982782)

## Usuário não autenticado

Usuário não poderá ter acesso a endpoints especifícos de acordo com seu tipo de conta.

![usuario nao autorizado](https://github.com/Al-Felipe/AV2-Arquitetura-Web/assets/105646899/8d9ca8d9-edbf-44f3-ab33-3febc6028e7e)

## Contato

Se você se interessou pelo projeto contate me pelo email felipealves3580@gmail.com ou pelo Github.

