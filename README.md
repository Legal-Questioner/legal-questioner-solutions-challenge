# Legal Questioner

Created for the GDSC Solutions Challenge 2024.

## Running the Website Frontend

Make sure you have `npm`, `node`, `react-scripts`, `axios`, and `tailwind-css` installed.

Run the application by
```sh
cd ./legal-frontend && npm start
```
This will begin the react app on port 3000.

## Running The Server Backend

### Initialize a Postgres instance

The recommended way of setting up a postgres instance that our backend can access is through Docker.

Make sure Docker and docker-compose is installed and run
```sh
cd ./legalquestionizer && docker-compose up
```
This will initialize a postgres docker container. When you launch the backend, this database should be populated automatically.

As long as you keep this container alive, the database should persist between backend instances.

### Env File requirements

> If you're running into strange errors, make sure you have this configured properly. The errors thrown from missing environment variables can be complex. 

Running the backend locally currently requires environment variables to be configured manually.


Create a `.env` file in the server project root (`legal-questioner/legalquestionizer`).

- `PROJECT_ID`: This is a required environmental variable, Get from GCP Console.
- `GEMINI_CHAR_LIMIT`: This is an optional environmental variable, if not set, is defaulted to 30000.
- `LOCATION`: This is an optional environmental variable, if not set, is defaulted to `us-central1`

The `.env` file should take the format
```
In ./legal-questioner/legalquestionizer/.env:

    PROJECT_ID={PROJECT_ID}
    GEMINI_CHAR_LIMIT={GEMINI_CHAR_LIMIT}
    LOCATION={LOCATION}
```

### Authenticating on GCI

Make sure you have the google cloud SDK installed. Run
```sh
gcloud config set project {PROJECT_ID} && gcloud auth login
```
Replacing `PROJECT_ID` with the project id (this will be same as the java environment variable) and `ACCOUNT` with the gmail account you use to access the GCP console. 

You may also get an error telling you that your default credentials aren't set. In this case, run
```sh
gcloud auth application-default login
```
to create and store a set of default credentials that the GCP SDK can access.

### Launching the server

Begin the persistent server with by running
```sh
cd ./legalquestionizer && ./gradlew bootRun
```
Your terminal might display a loading bar that pauses at 80%. This is normal, and means that your server is live. It'll only reach 100% if the web server exits.