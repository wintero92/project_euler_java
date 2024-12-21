FROM ubuntu:noble

# Install essential tools and set up Amazon Corretto
RUN apt-get update && \
    apt-get install -y wget gnupg unzip && \
    wget -O - https://apt.corretto.aws/corretto.key | gpg --dearmor -o /usr/share/keyrings/corretto-keyring.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/corretto-keyring.gpg] https://apt.corretto.aws stable main" | tee /etc/apt/sources.list.d/corretto.list && \
    apt-get update && \
    apt-get install -y java-21-amazon-corretto-jdk

# Install Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.3-bin.zip && \
    unzip gradle-8.3-bin.zip -d /opt && \
    ln -s /opt/gradle-8.3/bin/gradle /usr/bin/gradle && \
    rm gradle-8.3-bin.zip

# Set the working directory
WORKDIR /app
