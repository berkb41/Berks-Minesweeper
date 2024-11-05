# Use a base image with Java 11
FROM adoptopenjdk/openjdk11:latest

# Set the working directory
WORKDIR /app

# Copy the compiled Java classes
COPY . .

# Compile the Java source code
RUN javac org/minesweeper/*.java

# Set the main class
ENV MAIN_CLASS=org.minesweeper.Minesweeper

# Run the Minesweeper application
CMD ["java", "-cp", ".", "${MAIN_CLASS}"]