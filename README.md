# basic-step-indoor-location-provider-android
Concept of provider using the gyroscope and accelerometer to determine your location.

## Use

Instantiate the provider with Sensor System Service
```
ILBasicStepProvider = new BasicStepIndoorLocationProvider(getSystemService(SENSOR_SERVICE));
```

Set/Move provider's location:

```
ILNavisensProvider.setIndoorLocationi(indoorLocation);     
```

Set the provider in your Mapwize SDK:

```
mapwizePlugin.setLocationProvider(ILNavisensProvider);     
```

## Demo
Tap on the screen to set your location.

## Contribute

Contributions are welcome. We will be happy to review your PR.

## Support

For any support with this provider, please do not hesitate to contact [support@mapwize.io](mailto:support@mapwize.io)

## License

MIT