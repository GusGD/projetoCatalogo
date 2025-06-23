# Etapa 1: build do frontend
FROM node:18 as frontend
WORKDIR /app
COPY frontend ./frontend
WORKDIR /app/frontend
RUN npm install
RUN npm run build

# Etapa 2: build da aplicação Go
FROM golang:1.21 as backend
WORKDIR /app
COPY . .
COPY --from=frontend /app/frontend/dist ./frontend/dist
RUN go build -o server

# Etapa final: container minimalista
FROM alpine:latest
WORKDIR /root/
COPY --from=backend /app/server .
COPY --from=backend /app/frontend/dist ./frontend/dist
EXPOSE 8080
CMD ["./server"]
