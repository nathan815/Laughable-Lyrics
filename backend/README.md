# Laughable Lyrics backend
NodeJS Express backend powering the REST API for the app

## Installation
0. Clone repo
0. `cd Laughable-Lyrics/backend`
0. `npm install`
0. Install and start mysql database ([Mac](https://gist.github.com/nrollr/3f57fc15ded7dddddcc4e82fe137b58e), [Windows](https://dev.mysql.com/doc/refman/8.0/en/windows-installation.html))
0. Copy the env file: `cp .env.example .env` - fill in all of the secret values, including your local database info
0. Download gcp credentials file from Google Cloud Platform Console after setting up a translation project, and specify this file's location in the GOOGLE_APPLICATION_CREDENTIALS environmental variable in .env
0. Specify your GCP project ID in GOOGLE_PROJECT_ID environmental variable in .env
0. Run script to create database and tables: `./src/database/migrate.sh`
0. Start the server:
   - Normal start: `npm run start`
   - Auto reload when files are changed: `npm run watch` (requires [nodemon](https://nodemon.io/) - `npm install -g nodemon`)
