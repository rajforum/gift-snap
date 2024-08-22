# Gift Snap: Wedding Gifts and Cash Management App

**Gift Snap** is a comprehensive Android application designed to help users manage and track wedding gifts and cash. With intuitive UI and seamless functionality, GiftSnap makes it easy to organize and view all your wedding-related entries.

## Features

- **Home Screen**: Overview of total gifts, total cash, and recent entries.
- **Gift Entry**: Add or edit gift details.
- **Cash Tracking**: Log and edit cash entries.
- **Gift/Cash List**: Display and manage all entries with options to sort, filter, and search.
- **Reporting**: Generate and export reports.

## Technologies Used

- **Android**: Jetpack Compose for UI, Room for local database management, Hilt for dependency injection.
- **Kotlin**: Language for Android development.
- **Firebase**: Authentication and cloud storage (if enabled).

## Getting Started

### Prerequisites

- **Android Studio**: Ensure you have the latest version installed.
- **Android SDK**: Minimum API level 21.

### Setup

1. **Clone the Repository:**

   ```sh
   git clone https://github.com/rajforum/gift-snap.git

   ```

2. **Open the Project in Android Studio:**

   - Open Android Studio and select "Open an Existing Project."
   - Navigate to the cloned repository directory and open it.

3. **Install Dependencies:**

   - Sync the project with Gradle files to download and install all required dependencies.

4. **Build and Run the App:**

   - Connect an Android device or start an emulator.
   - Click on the "Run" button in Android Studio to build and launch the app.

### Configuration

#### Database Configuration

The app uses Room for local database management. The database schema and entities are defined in `AppDatabase`, `Gift`, and `CashEntry` classes. 

#### Firebase Setup (Optional)

To use Firebase for authentication and cloud storage:

1. **Add Firebase to Your Project:**
   - Follow the instructions in the [Firebase Console](https://console.firebase.google.com/) to add Firebase to your Android app.

2. **Configure Firebase Services:**
   - Set up Firebase Authentication, Realtime Database or Firestore, and Firebase Cloud Storage as needed.

### Usage

1. **Home Screen:**
   - View an overview of gifts and cash entries.

2. **Add/Edit Entries:**
   - Navigate to the Gift Entry or Cash Tracking screen to add or edit entries.

3. **View Lists:**
   - Access the Gift/Cash List screen to view and manage entries.

4. **Generate Reports:**
   - Use the Reporting screen to generate and export detailed reports.

### Troubleshooting

- **Database Errors:** Ensure Room dependencies are correctly configured and your database schema is up to date.
- **Hilt Issues:** Verify that Hilt dependencies are correctly set up and initialized.
- **UI Problems:** Check for issues in Jetpack Compose components and update Compose dependencies if necessary.

### Contributing

If you wish to contribute to the development of GiftSnap, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or fix.
3. Make your changes and test thoroughly.
4. Submit a pull request with a clear description of your changes.

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
