FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y \
    x11-apps \
    libxrender1 \
    libxtst6 \
    libxi6 \
    && rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the source files to the working directory
COPY src/ src/

# Compile the Java code
RUN javac src/Minesweeper.java -d out

ENV DISPLAY=:0

# Run the application
CMD ["java", "-cp", "out", "Minesweeper"]