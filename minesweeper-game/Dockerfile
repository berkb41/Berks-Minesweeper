FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y \
    x11-apps \
    libxrender1 \
    libxtst6 \
    libxi6 \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . /app

RUN mkdir -p out && \
    javac -d out src/**/*.java

ENV DISPLAY=:0

# Run the application
CMD ["java", "-cp", "out", "Minesweeper"]