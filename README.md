<h1>🌐 Login e Cadastro com Java Spring</h1>

<p><strong>Bem-vindo ao repositório!</strong> 🎉 Neste projeto, vamos desenvolver o backend de uma aplicação Fullstack para <strong>Login e Cadastro</strong> utilizando <strong>Java Spring Framework</strong>, <strong>JWT</strong>, e <strong>Spring Security</strong> para controle de autenticação e autorização.</p>

<h2>🌍 Tecnologias Utilizadas</h2>

<ul>
  <li><strong>Java Spring Boot</strong></li>
  <li><strong>Spring Security</strong></li>
  <li><strong>JWT (JSON Web Tokens)</strong></li>
  <li><strong>Spring Actuator</strong></li>
  <li><strong>Docker</strong></li>
</ul>

<h2>📂 Estrutura do Projeto</h2>
<pre>
.
├── config
│   └── prometheus.yml            # Configuração do Prometheus para coleta de métricas
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.loginauthapi
│   │   │       ├── controllers    # Endpoints de Login e Cadastro
│   │   │       ├── domain         # Modelos de Usuário
│   │   │       ├── dto            # Data Transfer Object
│   │   │       ├── config         # Configurações de CORS e Spring Security
│   │   │       └── repositories   # Repositórios de acesso a dados
│   └── resources
│       └── application.properties # Configurações de aplicação
└── docker-compose.yml             # Configuração das imagens Docker do Prometheus e Grafana
</pre>

<h2>🚀 Iniciando o Projeto</h2>

<ol>
  <li><strong>Clone o Repositório:</strong></li>
  <pre><code>git clone https://github.com/diegomayolo/login-auth-api.git
cd nome-do-repositorio
  </code></pre>

  <li><strong>Configure as Dependências:</strong><br>
      Certifique-se de que você possui <strong>Java 11+</strong> e <strong>Maven</strong> instalados. Execute o comando abaixo para baixar as dependências:</li>
  <pre><code>mvn install</code></pre>

  <li><strong>Configurações de Segurança:</strong><br>
      Abra o arquivo <code>application.properties</code> e configure as variáveis necessárias, como o secret de JWT e as configurações do banco de dados.</li><br>

  <li><strong>Execute a Aplicação:</strong></li>
  <pre><code>mvn spring-boot:run</code></pre>
</ol>

<p>Agora, a API estará disponível em <code>http://localhost:8080</code>.</p>

<h2>📜 Endpoints</h2>

<ul>
  <li><strong>POST /auth/register</strong> – Criação de novo usuário</li>
  <li><strong>POST /auth/login</strong> – Login e geração de token JWT</li>
  <li><strong>GET /user</strong> – Perfil do usuário autenticado (requer token)</li>
</ul>

<p><strong>Nota:</strong> Adicione o token JWT ao cabeçalho das requisições protegidas usando o campo <code>Authorization: Bearer {seu_token}</code>.</p>

<h2>🔑 Funcionalidades Principais</h2>

<ul>
  <li><strong>Cadastro de Usuário:</strong> Armazenamento seguro de credenciais.</li>
  <li><strong>Autenticação JWT:</strong> Geração e validação de tokens de acesso.</li>
</ul>

<h2>📊 Monitoramento com Spring Actuator</h2>
<p>Neste projeto utilizei o <strong>Spring Boot Actuator</strong> para coletar métricas da aplicação. Para visualizar essas métricas, as seguintes ferramentas foram utilizadas:</p>

<ul>
  <li><a href="https://prometheus.io/"><strong>Prometheus:</strong></a> Uma ferramenta de monitoramento de código aberto que coleta e armazena métricas em tempo real, permitindo a análise de desempenho e a geração de alertas.</li>
  <li><a href="https://grafana.com/"><strong>Grafana:</strong></a> Uma plataforma de visualização que permite criar gráficos e dashboards interativos com as métricas coletadas, facilitando a análise e o monitoramento.</li>
  <li><strong>Início dos Serviços:</strong> Execute <code>docker-compose up</code> para criar as imagens do Prometheus e Grafana. A interface gráfica do Grafana estará disponível na porta <strong>3000</strong>.</li>
</ul>

<h2>📲 Frontend Disponível para Integração</h2>
<p>O frontend para integração com este backend está disponível para clone no repositório GitHub <a href="https://github.com/diegomayolo/login-auth-api.git">diegomayolo/login-auth-api</a>. Acesse e inicie a implementação Fullstack! 🚀</p>

<h2>📽 Vídeo Tutorial</h2>
<p>Neste repositório, você encontra o código completo abordado no <a href="https://www.youtube.com/watch?v=tJCyNV1G0P4&ab_channel=FernandaKipper%7CDev">vídeo tutorial</a>.🎥</p>

<hr>

<p>🚀 <strong>Vamos ao código!</strong></p>
