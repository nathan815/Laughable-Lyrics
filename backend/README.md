# Laughable Lyrics backend
NodeJS Express backend powering the REST API for the app

## Installation
1. Clone repo
2. `cd Laughable-Lyrics/backend`
2. `npm install`
3. Copy the env file: `cp .env.example .env` - fill in all of the secret values
4. Download gcp credentials file from Google Cloud Platform after setting up translation project, and specify this file's location in the GOOGLE_APPLICATION_CREDENTIALS environmental variable in .env
5. Specify your GCP translate project ID in GOOGLE_PROJECT_ID environmental variable in .env
6. Start the server:
   - Normal start: `npm run start`
   - Auto reload when files are changed: `npm run watch` (requires [nodemon](https://nodemon.io/) - `npm install -g nodemon`)
