FROM nginx:alpine

EXPOSE 80

COPY /conf.d/nginx.conf /etc/nginx/conf.d/nginx.conf

CMD ["nginx", "-g", "daemon off;"]