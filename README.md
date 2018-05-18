# Basic Step IndoorLocation Provider for Android

This is a very very basic relative motion provider to illustrate how motion can be used to update a phone location from an inital location. It basically counts the steps you are making and makes the location to move of a fixed distance in the direction given by the compass.

This provider is built for education purpose and is not intended to be used in critical applications. For a more precise and robust solution, we advise to have a look at the [Navisens IndoorLocation Provider](https://github.com/IndoorLocation/navisens-indoor-location-provider-android).

## Use

Instantiate the provider with Sensor System Service

```
BasicStepIndoorLocationProvider basicStepProvider = new BasicStepIndoorLocationProvider(getSystemService(SENSOR_SERVICE), sourceIndoorLocationProvider);
```

Set/Move provider's location:

```
basicStepProvider.setIndoorLocation(indoorLocation);     
```

Set the provider in your Mapwize SDK:

```
mapwizePlugin.setLocationProvider(basicStepProvider);     
```

## Demo app
A simple demo application to test the provider is available in the /app directory.

You will need to set your credentials in BasicStepIndoorLocationProviderDemoApplication.

A sample key is provided for Mapwize. Please note that this keys can only be used for testing purposes, with very limited traffic, and cannot be used in production. Get your own key from [mapwize.io](https://www.mapwize.io). Free accounts are available.

To initialize the position, simply click on the map. Then move around and see the position moving.

## Contribute

Contributions are welcome. We will be happy to review your PR.

## Support

For any support with this provider, please do not hesitate to contact [support@mapwize.io](mailto:support@mapwize.io)

## License

MIT
